package com.sh.lmd.api.UserPowerApi.controller;

import com.sh.common.vo.R;
import com.sh.lmd.api.UserPowerApi.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("coupon/findCoupon.do")
    public R findcoupon(@RequestParam("uid")int uid, @RequestParam("status")int status, @RequestParam("page") int page){
        return  couponService.findcoupon(uid,status,page);
    }

    @GetMapping("coupon/getChangeCoupon.do")
    public R exchangeCoupon(@RequestParam("password") String password,@RequestParam("uid") int uid){
        return couponService.exchangeCoupon(password,uid);
    }
}
