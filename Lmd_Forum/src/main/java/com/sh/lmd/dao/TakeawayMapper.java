package com.sh.lmd.dao;


import com.sh.lmd.entity.Takeaway;

import java.util.List;

public interface TakeawayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Takeaway record);

    int insertSelective(Takeaway record);

    Takeaway selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Takeaway record);

    int updateByPrimaryKeyWithBLOBs(Takeaway record);

    int updateByPrimaryKey(Takeaway record);

    public List<Takeaway> findAll();

    List<Takeaway> selectBytitle(String title);
}