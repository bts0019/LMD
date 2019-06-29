package com.sh.lmd.server.dao;

import com.sh.lmd.entity.TUser;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from t_user where phone = #{phone}")
    TUser selectByPhone(String phone);
}
