package com.sh.lmd.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.sh.common.config.ProjectConfig;

import com.sh.common.jwt.JwtUtil;
import com.sh.common.model.LoginToken;
import com.sh.common.util.EncryptionUtil;
import com.sh.common.util.HttpUtils;
import com.sh.common.util.JedisUtil;
import com.sh.common.vo.R;
import com.sh.lmd.account.dao.TAdressMapper;
import com.sh.lmd.account.dao.TUserMapper;
import com.sh.lmd.account.service.AccountService;
import com.sh.lmd.entity.TAdress;
import com.sh.lmd.entity.TUser;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dks
 * @date 2019/6/27 20:44
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JedisUtil jedisUtil;

    @Autowired(required = false)
    private TUserMapper tUserMapper;

    @Autowired(required = false)
    private TAdressMapper tAdressMapper;

    @Override
    public R bandkCheck(String cardNo, String idNo, String name, String phoneNo) throws Exception {

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + ProjectConfig.ALIAPPCODES);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("ReturnBankInfo", "YES");
        bodys.put("cardNo", cardNo);
        bodys.put("idNo", idNo);
        bodys.put("name", name);
        bodys.put("phoneNo", phoneNo);
        HttpResponse response = HttpUtils.doPost(ProjectConfig.ALIHOST, ProjectConfig.IDCARDPATH, "GET", headers, querys, bodys);
        return R.setOK("OK",EntityUtils.toString(response.getEntity()));
    }

    @Override
    public R idCardCheck(String idCard, String name) throws Exception {

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + ProjectConfig.ALIAPPCODES);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idCard", idCard);
        querys.put("name", name);
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/java/cmapi028649.zip
        HttpResponse response = HttpUtils.doGet(ProjectConfig.ALIHOST, ProjectConfig.IDCARDPATH, "GET", headers, querys);
        return R.setOK("OK", EntityUtils.toString(response.getEntity()));
    }

    @Transient
    @Override
    public R bindEmail(String email, String token) {

        //判断用户是否登录
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);
        if(null != user){
            //判断是否拥有邮箱

            TUser tUser = tUserMapper.selectById(user.getUserId());
            //修改邮箱
            /*email = EncryptionUtil.AESDec(ProjectConfig.PASSRSAPRI, email);*/
            if(tUser.getEmail() != null){
                tUserMapper.updateEmailByUserId(user.getUserId(), email);
                return R.setOK("邮箱绑定成功", null);
            }
        }else{
            return R.setERROR("该用户没有登录");
        }
        return R.setERROR("邮箱验证失败");
    }

    @Override
    public R updatePwd(String password, String token) {

        //获取用户信息
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);

        if(null!=user){
            //对密码 进行加密
            String pwd = EncryptionUtil.AESEnc(ProjectConfig.PASSRSAPRI, password);
            tUserMapper.updatePasswordByUserId(user.getUserId(), pwd);
            return R.setOK("密码修改成功", null);
        }

        return R.setERROR("密码修改失败");
    }

    @Override
    public R updatePhone(String phone, String token) {

        //获取用户的信息
        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);

        if(user !=null){
            //修改手机号码
            TUser tUser = new TUser();
            tUser.setUserId(user.getUserId());
            tUser.setPhone(phone);
            tUserMapper.updateByUserId(tUser);
            return R.setOK("OK", null);
        }
        
        return R.setERROR("手机号码修改失败");
    }

    @Transient
    @Override
    public R addAdress(TAdress tAdress, String token) {

        TUser user = JSON.parseObject(jedisUtil.get(ProjectConfig.TOKENJWT+token),TUser.class);

        if (null != user) {
            if(tAdress!=null){
                int addressId = tAdressMapper.insertSelective(tAdress);
                TUser tUser = new TUser();
                tUser.setUserId(addressId);
                tUserMapper.updateByUserId(tUser);
                return R.setOK("OK", null);
            }
            return R.setERROR("请填写详细信息");
        }

        return R.setERROR("收货地址添加失败");
    }
}
