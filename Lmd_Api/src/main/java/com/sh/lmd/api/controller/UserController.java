package com.sh.lmd.api.controller;

import com.sh.common.vo.R;
import com.sh.lmd.api.service.UserService;
import com.sh.lmd.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    //新增
    @PostMapping("save.do")
    public R save(@RequestBody TUser user){
        return userService.save(user);
    }
    @GetMapping("/api/user/all.do")
    public R all(){
        return userService.all();
    }



}
