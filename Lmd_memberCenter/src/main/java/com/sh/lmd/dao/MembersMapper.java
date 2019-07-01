package com.sh.lmd.dao;


import com.sh.lmd.mentity.MemberInfo;
import com.sh.lmd.mentity.Members;

import java.util.List;

public interface MembersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Members record);

    int insertSelective(Members record);

    Members selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Members record);

    int updateByPrimaryKey(Members record);

    public List<Members> findAll();

    public List<MemberInfo> findAllInfo();
}