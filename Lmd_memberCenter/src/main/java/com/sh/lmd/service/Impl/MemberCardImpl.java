package com.sh.lmd.service.Impl;

import com.sh.lmd.dao.MembersMapper;
import com.sh.lmd.mentity.MemberInfo;
import com.sh.lmd.mentity.Members;
import com.sh.lmd.service.MemberCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberCardImpl implements MemberCardService {

    @Autowired(required = false)
    private MembersMapper membersMapper;
    @Override
    public List<Members> findAll() {

        return membersMapper.findAll();
    }

    @Override
    public List<MemberInfo> findAllInfo() {
        return membersMapper.findAllInfo();
    }


}
