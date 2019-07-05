package com.sh.lmd.service;

import com.sh.lmd.dao.GreenhandMapper;
import com.sh.lmd.entity.Greenhand;


import java.util.List;

public interface GreenhandService {

    public List<Greenhand> findAll();
    int insertSelective(Greenhand record);
}
