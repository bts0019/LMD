package com.sh.lmd.server.user.point.dao;


import com.sh.lmd.entity.TUser;

public interface TUserPointMapper {
    TUser queryPointById(int userId);

}