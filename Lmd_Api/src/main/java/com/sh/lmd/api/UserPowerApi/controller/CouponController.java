package com.sh.lmd.api.UserPowerApi.controller;

import com.sh.common.config.ProjectConfig;
import com.sh.common.vo.R;
import com.sh.lmd.api.UserPowerApi.service.CouponService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("coupon/findCoupon.do")
    public R findcoupon(@RequestParam("token") String token, @RequestParam("page") int page){
        return  couponService.findcoupon(token,page);
    }

    @GetMapping("coupon/getChangeCoupon.do")
    public R exchangeCoupon(@RequestParam("password") String password,@RequestParam("token") String token){
        return couponService.exchangeCoupon(password,token);
    }
}
