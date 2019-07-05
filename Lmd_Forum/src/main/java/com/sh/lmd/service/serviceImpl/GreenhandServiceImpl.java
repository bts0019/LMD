package com.sh.lmd.service.serviceImpl;

import com.sh.lmd.dao.GreenhandMapper;
import com.sh.lmd.entity.Greenhand;
import com.sh.lmd.service.GreenhandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenhandServiceImpl implements GreenhandService {

  @Autowired
    private GreenhandMapper greenhandMapper;
    @Override
    public List<Greenhand> findAll() {
        return greenhandMapper.findAll();
    }

    @Override
    public int insertSelective(Greenhand record) {
        return greenhandMapper.insertSelective(record);
    }
}
