package com.sh.lmd.server.user.point.service.impl;

import com.sh.common.vo.R;
import com.sh.lmd.server.user.point.dao.TUserPointMapper;
import com.sh.lmd.server.user.point.service.TUserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserPointServiceImpl implements TUserPointService {
    @Autowired
    private TUserPointMapper pointMapper;


    @Override
    public R queryPointById(int userId) {
        return R.setOK("OK", pointMapper.queryPointById(userId));
    }
}
