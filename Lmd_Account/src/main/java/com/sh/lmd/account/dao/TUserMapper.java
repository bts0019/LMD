package com.sh.lmd.account.dao;

import com.sh.lmd.entity.TUser;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {


    TUser selectById(Integer userId);

    //修改用户id
    void updateEmailByUserId(@Param("userId") Integer userId, @Param("email") String email);

    //修改用户密码
    void updatePasswordByUserId(@Param("userId") Integer userId, @Param("password") String password);

    //修改用户信息
    void updateByUserId(TUser user);
}