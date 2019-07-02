package com.sh.lmd.service.Impl;

import com.sh.lmd.dao.CardcenterMapper;
import com.sh.lmd.mentity.Cardcenter;
import com.sh.lmd.service.CardCentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardCentServiceImpl implements CardCentService {

    @Autowired
    private CardcenterMapper cardcenterMapper;
    @Override
    public Cardcenter selectByPrimaryKey(Integer id) {
        return cardcenterMapper.selectByPrimaryKey(id);
    }
}
