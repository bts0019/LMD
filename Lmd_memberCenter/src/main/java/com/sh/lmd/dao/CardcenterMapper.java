package com.sh.lmd.dao;


import com.sh.lmd.mentity.Cardcenter;


public interface CardcenterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cardcenter record);

    int insertSelective(Cardcenter record);

    Cardcenter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cardcenter record);

    int updateByPrimaryKey(Cardcenter record);

}