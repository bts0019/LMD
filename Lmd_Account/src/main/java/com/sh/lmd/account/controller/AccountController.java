package com.sh.lmd.account.controller;

import com.sh.common.vo.R;
import com.sh.lmd.account.service.AccountService;
import com.sh.lmd.entity.TAdress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dks
 * @date 2019/7/1 20:05
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("account/bindEmail.do")
    public  R bindEmail(@RequestParam("email") String email, @RequestParam("token") String token){
        return accountService.bindEmail(email, token);
    }

    @RequestMapping("account/updatePhone.do")
    public  R updatePhone(@RequestParam("phone") String phone, @RequestParam("token") String token){
        return accountService.updatePhone(phone, token);
    }

    @RequestMapping("account/addAdress.do")
    public  R addAdress(@RequestBody TAdress tAdress, @RequestParam("token") String token){
        return accountService.addAdress(tAdress, token);
    }
    @RequestMapping("account/updatePwd.do")
    public  R updatePwd(@RequestParam("password") String password, @RequestParam("token") String token){
        return accountService.updatePwd(password, token);
    }
    @RequestMapping("account/checkUser.do")
    public  R checkUser(@RequestParam("idCard") String idCard, @RequestParam("name") String name){
        try {
            return accountService.idCardCheck(idCard, name);
        } catch (Exception e) {
            e.printStackTrace();
           return  R.setERROR("验证失败");
        }
    }



}
