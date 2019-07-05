package com.sh.lmd.api.account.controller;

import com.sh.common.config.ProjectConfig;
import com.sh.common.vo.R;
import com.sh.lmd.api.account.service.AccountService;
import com.sh.lmd.entity.TAdress;
import org.apache.commons.codec.language.bm.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dks
 * @date 2019/7/2 14:45
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("api/account/bindEmail.do")
    public R bindEmail(@RequestParam(value = "email") String email, @RequestParam("token") String token){
        System.out.println("-----------------------------------------------------");
    /*    System.out.println(request.getParameter("token"));
        System.out.println(request.getHeader("token"));*/
        System.out.println(token);
        System.out.println("-----------------------------------------------------");
        /*System.out.println(request.getHeader(ProjectConfig.TOKENHEAD));*/
        return accountService.bindEmail1(email, ""+token);
    }

    @GetMapping("api/account/updatePhone.do")
    public  R updatePhone(@RequestParam(value = "phone") String phone,@RequestParam("token") String token){

        return accountService.updatePhone(phone, token);
    }

    @GetMapping("api/account/addAdress.do")
    public  R addAdress(@RequestBody TAdress tAdress, @RequestParam("token") String token){
        return accountService.addAdress(tAdress, token);
    }

    @GetMapping("api/account/updatePwd.do")
    public  R updatePwd(@RequestParam("password") String password, @RequestParam("token") String token){
        return accountService.updatePwd(password, token);
    }

    @GetMapping("api/account/checkUser.do")
    public  R checkUser(@RequestParam("idCard") String idCard, @RequestParam("name") String name){
       return accountService.checkUser(idCard, name);
    }
}
