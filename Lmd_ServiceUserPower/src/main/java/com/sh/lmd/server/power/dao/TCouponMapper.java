package com.sh.lmd.server.power.dao;

import com.sh.lmd.entity.TCoupon;

import java.util.List;
import java.util.Map;

/**
 * 对用户所属 积分进行操作
 * author:Tianshui Bai
 */
public interface TCouponMapper {

    /**
     * 根据优惠卷状态查询用户所属优惠卷
     */
    List<TCoupon> selectCouponByUserAndStatus(Map<String,Integer> map);

    /**
     * 根据优惠卷密码查询优惠卷
     * @param password
     * 优惠卷密码
     * @return
     * 优惠卷对象
     */
    TCoupon selectCouponByPassword(String password);

    /**
     * 根据优惠卷修改优惠卷属性
     * @param map
     */
    void updateCouponByPassword(Map<String,Object> map);



}
