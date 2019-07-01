package com.sh.lmd.service;


import com.sh.lmd.mentity.MemberInfo;
import com.sh.lmd.mentity.Members;

import java.util.List;

public interface MemberCardService {

    public List<Members> findAll();

    public List<MemberInfo> findAllInfo();
}
