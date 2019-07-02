package com.sh.lmd.dao;


import com.sh.lmd.entity.Greenhand;

import java.util.List;

public interface GreenhandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Greenhand record);

    int insertSelective(Greenhand record);

    Greenhand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Greenhand record);

    int updateByPrimaryKeyWithBLOBs(Greenhand record);

    int updateByPrimaryKey(Greenhand record);

    public List<Greenhand> findAll();
}