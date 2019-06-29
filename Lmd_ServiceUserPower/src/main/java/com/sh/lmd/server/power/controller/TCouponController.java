package com.sh.lmd.server.power.controller;

import com.sh.common.vo.R;
import com.sh.lmd.server.power.service.TCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TCouponController {

    @Autowired
    private TCouponService tCouponService;

    /**
     * 查找优惠卷

     * @return
     */
    @GetMapping("coupon/getcoupon.do")
    public R findcoupon(@RequestParam("token")String token,@RequestParam("page") int page){
        return tCouponService.findCouponByuidAndstatus(token,page);
    }

    /**
     * 兑换优惠卷根据优惠卷密码
     * @param password
     * @return
     */
    @GetMapping("coupon/getChangeCoupon.do")
    public R exchangeCoupon(@RequestParam("password") String password,@RequestParam("token") String token){
        return tCouponService.findCouponByPassword(password,token);
    }

}
