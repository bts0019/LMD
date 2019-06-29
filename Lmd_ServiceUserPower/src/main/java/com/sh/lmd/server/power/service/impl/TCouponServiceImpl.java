package com.sh.lmd.server.power.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.common.config.ProjectConfig;
import com.sh.common.util.JedisUtil;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TCoupon;
import com.sh.lmd.entity.TUser;
import com.sh.lmd.server.power.dao.TCouponMapper;
import com.sh.lmd.server.power.service.TCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TCouponServiceImpl implements TCouponService {

    @Autowired(required = false)
    private TCouponMapper couponDao;

    @Autowired(required = false)
    private JedisUtil jedisUtil;

    @Override
    public R findCouponByuidAndstatus(String token,int page) {
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("uid",user.getUserid());
        map.put("status",user.getStatus());
        PageHelper.startPage(page,6);
        PageInfo<TCoupon> pageInfo = new PageInfo<>(couponDao.selectCouponByUserAndStatus(map));
        return R.setOK("",pageInfo);
    }

    @Override
    public R findCouponByPassword(String password,String token) {
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);
        Map<String,Object> map = new HashMap<>();
        TCoupon tCoupon = couponDao.selectCouponByPassword(password);
        if (tCoupon == null){
            return R.setERROR("无此优惠卷！或者优惠卷密码填写错误！");
        }else if (tCoupon.getUid() != null){
            return R.setERROR("此优惠卷密码已经兑换！不可再次兑换");
        }else {

            map.put("password",password);
            map.put("uid",user.getUserid());
            couponDao.updateCouponByPassword(map);
            return R.setOK("优惠卷兑换成功！",null);
        }
    }
}
