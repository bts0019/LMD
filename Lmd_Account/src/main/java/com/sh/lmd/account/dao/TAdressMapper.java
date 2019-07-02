package com.sh.lmd.account.dao;


import com.sh.lmd.entity.TAdress;

public interface TAdressMapper {
    int insert(TAdress record);

    int insertSelective(TAdress record);
}