package com.sh.lmd.server.user.controller;

import com.sh.common.exception.UserException;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TUser;
import com.sh.lmd.server.user.service.UserService;
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
    @PostMapping("user/save.do")
    public R save(@RequestBody TUser user) throws UserException {
        return userService.save(user);
    }
    //查询
    @GetMapping("user/all.do")
    public R all(){
        return userService.all();
    }

}
