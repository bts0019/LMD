package com.sh.lmd.api.account.controller;

import com.sh.common.config.ProjectConfig;
import com.sh.common.vo.R;
import com.sh.lmd.api.account.service.AccountService;
import com.sh.lmd.entity.TAdress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dks
 * @date 2019/7/2 14:45
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("api/account/bindEmail.do")
    public R bindEmail(@RequestParam("email") String email, HttpServletRequest request){
        return accountService.bindEmail(email, request.getHeader(ProjectConfig.TOKENHEAD));
    }

    @RequestMapping("api/account/updatePhone.do")
    public  R updatePhone(@RequestParam("phone") String phone, HttpServletRequest request){

        return accountService.updatePhone(phone, request.getHeader(ProjectConfig.TOKENHEAD));
    }

    @RequestMapping("api/account/addAdress.do")
    public  R addAdress(@RequestBody TAdress tAdress, HttpServletRequest request){

        return accountService.addAdress(tAdress, request.getHeader(ProjectConfig.TOKENHEAD));
    }

    @RequestMapping("api/account/updatePwd.do")
    public  R updatePwd(@RequestParam("password") String password, HttpServletRequest request){
        return accountService.updatePwd(password, request.getHeader(ProjectConfig.TOKENHEAD));
    }

    @RequestMapping("api/account/checkUser.do")
    public  R checkUser(@RequestParam("idCard") String idCard, @RequestParam("name") String name){
       return accountService.checkUser(idCard, name);
    }
}
