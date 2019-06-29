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
    public R findMyInvite(@RequestParam("uid") Integer uid){
        return inviteService.findInviteByUid(uid);
    }

    @GetMapping("invite/findInviteUser.do")
    public R findInviteUser(@RequestParam("uid") Integer uid){
        return inviteService.findInviteUser(uid);
    }

}
