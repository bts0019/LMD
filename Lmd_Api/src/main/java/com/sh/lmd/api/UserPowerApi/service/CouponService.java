package com.sh.lmd.api.UserPowerApi.service;

import com.sh.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserPowerProvider")
public interface CouponService {

    @GetMapping("coupon/getcoupon.do")
    R findcoupon(@RequestParam("uid")int uid, @RequestParam("status")int status, @RequestParam("page") int page);

    @GetMapping("coupon/getChangeCoupon.do")
    public R exchangeCoupon(@RequestParam("password") String password,@RequestParam("uid") int uid);
}
