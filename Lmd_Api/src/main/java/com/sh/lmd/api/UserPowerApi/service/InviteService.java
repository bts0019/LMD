package com.sh.lmd.api.UserPowerApi.service;

import com.sh.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserPowerProvider")
public interface InviteService {

    @GetMapping("invite/findMyInvite.do")
    public R findMyInvite(@RequestParam("uid") Integer uid);

    @GetMapping("invite/findInviteUser.do")
    public R findInviteUser(@RequestParam("uid") Integer uid);

}
