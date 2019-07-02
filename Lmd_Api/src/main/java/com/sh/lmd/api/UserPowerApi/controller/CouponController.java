package com.sh.lmd.api.UserPowerApi.controller;

import com.sh.common.config.ProjectConfig;
import com.sh.common.vo.R;
import com.sh.lmd.api.UserPowerApi.service.CouponService;
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
    public R findcoupon(HttpServletRequest request, @RequestParam("page") int page){
        return  couponService.findcoupon(request.getHeader(ProjectConfig.TOKENHEAD),page);
    }

    @GetMapping("coupon/getChangeCoupon.do")
    public R exchangeCoupon(@RequestParam("password") String password,HttpServletRequest request){
        return couponService.exchangeCoupon(password,request.getHeader(ProjectConfig.TOKENHEAD));
    }
}
