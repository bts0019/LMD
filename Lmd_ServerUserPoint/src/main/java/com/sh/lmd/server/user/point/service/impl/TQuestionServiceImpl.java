package com.sh.lmd.server.user.point.service.impl;

import com.sh.common.config.ProjectConfig;
import com.sh.common.jwt.JwtUtil;
import com.sh.common.model.LoginToken;
import com.sh.common.util.JedisUtil;
import com.sh.common.util.TimeUtil;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TPointlog;
import com.sh.lmd.server.user.point.dao.TPointlogMapper;
import com.sh.lmd.server.user.point.dao.TQuestionMapper;
import com.sh.lmd.server.user.point.service.TQuestionService;
import com.sh.lmd.server.user.point.util.RandomUtil;
import com.sh.lmd.server.user.point.util.UserTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TQuestionServiceImpl implements TQuestionService {
    @Autowired
    private TQuestionMapper questionMapper;
//    @Autowired
//    private TUserMapper userMapper;
    @Autowired
    private TPointlogMapper pointlogMapper;
    @Autowired(required = false)
    private JedisUtil jedisUtil;

    @Override
    public R queryQuestion() {
        int id = RandomUtil.createNum(1, 7);
        return R.setOK("OK", questionMapper.queryQuestion(id));
    }

    @Override
    public R answerQuestion(String token, String answer) {
        // 1、今天是否已经答过题，今天答过题的人 存储到Redis，当天有效，set集合，
        LoginToken loginToken = UserTokenUtil.parseToken(JwtUtil.parseJWT(token));
        boolean isSign = true;
        boolean isFirst = false;
        // 1、验证存储签到的集合是否存在
        if (jedisUtil.exists(ProjectConfig.SIGNKEY)){
            // 2、验证当前的登录用户是否答题
            if (jedisUtil.sismember(ProjectConfig.SIGNKEY, loginToken.getPhone())){
                isSign = false;
                return R.setERROR("明日再来吧！！！");
            }
        } else {
            isFirst = true;
        }
        if (isSign){
            // 3、今天可以答题
            TPointlog lastLog = questionMapper.selectByUserIdLast(loginToken.getUid());
            int extra = 0;
            String info = "";
            int lxdays = 1;
            int points = RandomUtil.createNum(10, 15);
            // 4、之前是否答过题
            if (lastLog == null){
                // 5、之前没有答过题、
                if (questionMapper.selectAnswer(answer) == null){
                    // 答错题，获得 1 积分，反之，获 2 积分
                    extra = 1;
                    info = "回答错误，赠送积分：" + extra;
                } else {
                    extra = 2;
                    info = "回答正确，赠送积分：" + extra;
                }
            } else {
                // 连续答题，非连续答题
                // 6、验证是否连续答题
                if (TimeUtil.getDistanceDays(lastLog.getPtime()) == 1){
                    // 连续答题
                    lxdays = lastLog.getDays() + 1;
                    if (lxdays %7 == 0){
                        // 连续答题7天
                        extra = 7;
                        info = "恭喜您，已连续答题" + lxdays + "天，特别奖励：7积分";
                    } else if (lxdays %30 == 0){
                        extra = 30;
                        info = "恭喜您，已连续答题" + lxdays + "天，特别奖励：30积分";
                    } else if(lxdays %365 == 0){
                        extra = lxdays;
                        info = "恭喜您，连续签到：" + lxdays + "天，特别奖励:" + lxdays + "积分";
                    }
                } else{
                    // 非连续答题
                    info = "你上次是在：" + TimeUtil.getFormat(lastLog.getPtime()) + "签到";
                }
            }
            // 保存到数据库
            // 答题日志
            TPointlog pointlog = new TPointlog();
            pointlog.setUserId(loginToken.getUid());
            pointlog.setPtype("人人答");
            pointlog.setPoints(extra);
            pointlog.setPtime(new Date());
            pointlog.setWay(1);
            pointlog.setDays(lxdays);
            pointlogMapper.savePointlog(pointlog);
            // 用户积分更新
//            TUser user = new TUser();
//            user.setUserid(loginToken.getUid());
//            user.setIntegralid(user.getIntegralid() + extra);
//            userMapper.update(loginToken.getUid(),)

            // 保存答题信息到Rsdis
            jedisUtil.sadd(ProjectConfig.SIGNKEY, loginToken.getPhone());
            // 如果是今天第一次答题，需要设置答题的数据的key的有效期，当天剩余的秒数
            if (isFirst){
                jedisUtil.expire(ProjectConfig.SIGNKEY, TimeUtil.getLastSeconds());
            }
            return R.setOK("答题完成", pointlog);

        }



        return null;
    }

    @Override
    public R checkAnswer(String answer) {
        if (questionMapper.selectAnswer(answer) == null){
            return R.setERROR("答题错误，获得 1 积分，明天再来吧~~~");
        } else {
            return R.setOK("回答正确，恭喜您获得 2 积分", null);
        }
    }
}
