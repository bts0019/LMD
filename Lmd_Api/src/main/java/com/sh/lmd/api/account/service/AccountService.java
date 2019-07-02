package com.sh.lmd.api.account.service;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TAdress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dks
 * @date 2019/7/2 14:09
 */
@FeignClient(value = "AccountProvider")
public interface AccountService {

    @RequestMapping("account/bindEmail.do")
    public  R bindEmail(@RequestParam("email") String email, @RequestParam("token") String token);

    @RequestMapping("account/updatePhone.do")
    public  R updatePhone(@RequestParam("phone") String phone, @RequestParam("token") String token);

    @RequestMapping("account/addAdress.do")
    public  R addAdress(@RequestBody TAdress tAdress, @RequestParam("token") String token);

    @RequestMapping("account/updatePwd.do")
    public  R updatePwd(@RequestParam("password") String password, @RequestParam("token") String token);

    @RequestMapping("account/checkUser.do")
    public  R checkUser(@RequestParam("idCard") String idCard, @RequestParam("name") String name);
}
