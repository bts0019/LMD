package com.sh.lmd.server.user.point.service.impl;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TCoupon;
import com.sh.lmd.entity.TPrizelog;
import com.sh.lmd.entity.TUser;
import com.sh.lmd.server.user.point.dao.TPointlogMapper;
import com.sh.lmd.server.user.point.dao.TPrizeMapper;
import com.sh.lmd.server.user.point.dao.TPrizelogMapper;
import com.sh.lmd.server.user.point.service.TPrizeService;
import com.sh.lmd.server.user.point.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TPrizeServiceImpl implements TPrizeService {
    @Autowired
    private TPrizeMapper prizeMapper;
    @Autowired
    private TPointlogMapper pointlogMapper;
    @Autowired
    private TPrizelogMapper prizelogMapper;
//    @Autowired
//    private TuserMapper userMapper;
    @Override
    public R extractPrize(int userId) {
        int pid = RandomUtil.createNum(1, 20000);
        String ptype = "";
        if (pid == 20000){
            ptype = "666现金";
        } else if (pid <= 5) {
            ptype = "168元卷";
        } else if (pid > 5 && pid <3338){
            ptype = "谢谢参与";
        } else if (pid >= 3337 && pid < 6670) {
            ptype = "10积分";
        } else if (pid >=6669 && pid < 10002) {
            ptype = "50积分";
        } else if (pid >= 10001 && pid < 13334){
            ptype = "1元卷";
        } else if (pid >= 13333 && pid < 16666) {
            ptype = "5元卷";
        }else {
            ptype = "10元卷";
        }
        TUser user = new TUser();
        TCoupon coupon = new TCoupon();
        TPrizelog prizelog = new TPrizelog();

        switch (ptype){
            case "5元卷" :
                prizelog.setPtime(new Date());
                prizelog.setPid(5);
                prizelog.setUserId(userId);
                prizelogMapper.save(prizelog);
                break;
            case "666现金" :
                break;
            case "50积分" :
                break;
            case "10元卷" :
                break;
            case "1元卷" :
                break;
            case "168元卷" :
                break;
            case "10积分" :
                break;
            case "谢谢参与" :
                break;


        }
        return null;
    }
}
