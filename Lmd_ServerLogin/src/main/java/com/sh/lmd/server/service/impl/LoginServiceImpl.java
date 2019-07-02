package com.sh.lmd.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.sh.common.config.ProjectConfig;
import com.sh.common.jwt.JwtUtil;
import com.sh.common.util.EncryptionUtil;
import com.sh.common.util.IdGenerator;
import com.sh.common.util.JedisUtil;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TUser;
import com.sh.lmd.server.dao.UserDao;
import com.sh.lmd.server.dao.UserLogDao;
import com.sh.lmd.server.model.LoginToken;
import com.sh.lmd.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class LoginServiceImpl  implements LoginService{


   @Autowired(required = false)
    private UserDao userDao;
   @Autowired(required = false)
   private UserLogDao logDao;
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private IdGenerator idGenerator;
    @Override
    public R login(String phone, String password) {
        R r;
        //先校验当前账号是否被锁定
        if (jedisUtil.exists(ProjectConfig.USERSD+phone)){
            r=R.setERROR("账号锁定中，剩余时间："+(jedisUtil.ttl(ProjectConfig.USERSD+phone)/60));
        }else {
            //1.校验用户名是否存在
            TUser user = userDao.selectByPhone(phone);
            if (user!=null){
                //2.校验密码是否正常
                if (Objects.equals(user.getPassword(), EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI,password))){
                    //登录成功
                    LoginToken loginToken =new LoginToken();
                    loginToken.setPhone(phone);
                    loginToken.setUid(user.getUserId());
                    loginToken.setId(idGenerator.nextId()+"");
                    //3.生成token
                    String token = JwtUtil.createJWT(loginToken.getId(), JSON.toJSONString(loginToken));
                    //4.存储到服务器
                    //1.String类型，user：phone token
                    jedisUtil.setex(ProjectConfig.TOKENPHONE+token,1800,token);
                    //String类型 token phone校验token是否有效
                    jedisUtil.setex(ProjectConfig.TOKENJWT+token,1800,JSON.toJSONString(user));
                    logDao.save(user.getUserId(),"登陆成功，令牌生成");
                    r= R.setOK("OK",token);




                }else {
                    logDao.save(user.getUserId(),"登录失败，密码有误");
                    r= R.setERROR("密码不正确");
                }
            }else{
                logDao.save(user.getUserId(),"登录失败，账号有误");
                r= R.setERROR("是不是还没账号，快来注册");
            }
            if (r.getCode()!=1){
                String key = ProjectConfig.USERLOGINCOUNT+phone;
                jedisUtil.setex(key +"_"+System.currentTimeMillis(),600,"1");
                Set<String> set = jedisUtil.keys(key+"*");
                if (set.size()==3){
                    logDao.save(user.getUserId(),"登录次数超过3次，账号被锁定");
                    //将当前账号冻结1小时
                    jedisUtil.setex(ProjectConfig.USERSD+phone,3600,"10分钟连续失败三次冻结账号");
                    r=R.setERROR("连续多次账号或密码错误，账号被锁定，请1小时之后再来登录");
                }
            }

        }

        return r;
    }

    @Override
    public R checkLogin(String token) {
        //1.校验token有效性
        if (JwtUtil.checkJWT(token)){
            //反解析 令牌 获取当初登录的手机号
            LoginToken loginToken = JSON.parseObject(JwtUtil.parseJWT(token),LoginToken.class);
            //获取当前手机号的令牌
            String t = jedisUtil.get(ProjectConfig.TOKENPHONE+loginToken.getPhone());
            //比对令牌
           if (Objects.equals(t,token)){
               return R.setOK("有效",token);
           }else{
               return R.setERROR("已经在其他地方登陆了");
           }


        }else {
            return R.setERROR("Token校验失败");

        }

    }

    @Override
    public R exitLogin(String token) {

        //1.校验token有效性
        if (JwtUtil.checkJWT(token)){
            jedisUtil.del(ProjectConfig.TOKENJWT+token);
            //反解析 令牌 获取当初登陆的手机号
            LoginToken loginToken = JSON.parseObject(JwtUtil.parseJWT(token),LoginToken.class);
            //获取当前手机的令牌
            jedisUtil.del(ProjectConfig.TOKENPHONE+loginToken.getPhone());
            return R.setOK("退出成功",null);

        }else {
            return R.setERROR("token校验失败");
        }

    }
}
