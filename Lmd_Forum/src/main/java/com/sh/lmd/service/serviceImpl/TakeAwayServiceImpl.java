package com.sh.lmd.service.serviceImpl;

import com.sh.lmd.dao.TakeawayMapper;
import com.sh.lmd.entity.Takeaway;
import com.sh.lmd.service.TakeAwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeAwayServiceImpl implements TakeAwayService {
    @Autowired(required = false)
    private TakeawayMapper takeawayMapper;
    @Override
    public List<Takeaway> findAll() {
        return takeawayMapper.findAll();
    }

    @Override
    public List<Takeaway> selectBytitle(String title) {
        return takeawayMapper.selectBytitle(title);
    }
}
