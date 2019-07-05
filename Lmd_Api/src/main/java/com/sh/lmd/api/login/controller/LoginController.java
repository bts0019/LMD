package com.sh.lmd.api.login.controller;

import com.sh.common.config.ProjectConfig;
import com.sh.common.vo.R;
import com.sh.lmd.api.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *@Author feri
 *@Date Created in 2019/6/14 16:25
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录
    @PostMapping("/api/login/login.do")
    public R login(String phone,String password){
        return loginService.login(phone, password);
    }
    //检查是否有效
    @GetMapping("api/login/checklogin.do")
    public R check(@RequestParam("token") String token){
        return loginService.check(token);
    }
    //注销
    @GetMapping("api/login/exit.do")
    public R exit(@RequestParam("token") String token){
        return loginService.exit(token);
    }
}
