package com.sh.lmd.server.power.service;

import com.sh.common.vo.R;

public interface TCouponService {
    /**
     * 根据用户id 优惠卷状态和页数查询用户所属优惠卷
     * 页数
     * @returnint uid, int status,int page
     */
    R findCouponByuidAndstatus(String token,int page);

    /**
     * 根据优惠卷查询优惠卷
     * @param password
     * @return
     */
    R findCouponByPassword(String password,String token);
}
