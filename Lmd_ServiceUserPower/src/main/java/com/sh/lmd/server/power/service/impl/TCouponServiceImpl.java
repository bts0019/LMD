package com.sh.lmd.server.power.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TCoupon;
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

    @Override
    public R findCouponByuidAndstatus(int uid, int status,int page) {
        Map<String,Integer> map = new HashMap<>();
        map.put("uid",uid);
        map.put("status",status);
        PageHelper.startPage(page,6);
        PageInfo<TCoupon> pageInfo = new PageInfo<>(couponDao.selectCouponByUserAndStatus(map));
        return R.setOK("",pageInfo);
    }

    @Override
    public R findCouponByPassword(String password,int uid) {
        Map<String,Object> map = new HashMap<>();
        TCoupon tCoupon = couponDao.selectCouponByPassword(password);
        if (tCoupon == null){
            return R.setERROR("无此优惠卷！或者优惠卷密码填写错误！");
        }else if (tCoupon.getUid() != null){
            return R.setERROR("此优惠卷密码已经兑换！不可再次兑换");
        }else {

            map.put("password",password);
            map.put("uid",uid);
            couponDao.updateCouponByPassword(map);
            return R.setOK("优惠卷兑换成功！",null);
        }
    }
}
