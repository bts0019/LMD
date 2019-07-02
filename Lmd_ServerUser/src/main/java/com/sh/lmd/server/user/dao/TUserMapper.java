package com.sh.lmd.server.user.dao;

import com.sh.lmd.entity.TUser;

import java.util.List;

public interface TUserMapper {
    int insert(TUser record);

    List<TUser> all();
}