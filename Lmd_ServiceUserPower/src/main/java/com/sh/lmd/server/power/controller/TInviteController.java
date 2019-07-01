package com.sh.lmd.server.power.controller;

import com.sh.common.vo.R;
import com.sh.lmd.server.power.service.TInviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TInviteController {

    @Autowired
    private TInviteService inviteService;

    @GetMapping("invite/findMyInvite.do")
    public R findMyInvite(@RequestParam("token") String token){
        return inviteService.findInviteByUid(token);
    }

    @GetMapping("invite/findInviteUser.do")
    public R findInviteUser(@RequestParam("token") String token){
        return inviteService.findInviteUser(token);
    }

}
