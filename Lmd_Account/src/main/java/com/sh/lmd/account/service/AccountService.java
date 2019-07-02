package com.sh.lmd.account.service;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TAdress;

import java.io.IOException;

/**
 * @author dks
 * @date 2019/6/27 20:37
 */
public interface AccountService {

    /**
     * 绑定,或修改邮箱
     */
    R bindEmail(String email, String token);

    R updatePwd(String password, String token);

    /**
     * 修改手机号码
     * @param phone
     * @param token
     * @return
     */
    R updatePhone(String phone, String token);

    /**
     * 添加
     * @param tAdress
     * @param token
     * @return
     */
    R addAdress(TAdress tAdress, String token);

    /**
     * 通过名字和参数验证身份证是否正确
     * @param idCard
     * @param name
     * @return
     */
    R idCardCheck(String idCard, String name) throws Exception;

    /**
     * 银行卡信息验证
     * @param cardNo
     * @param idNo
     * @param name
     * @param phoneNo
     * @return
     */
    R bandkCheck(String cardNo, String idNo, String name, String phoneNo) throws Exception;
}
