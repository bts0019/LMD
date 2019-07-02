package com.sh.lmd.server.user.point.service.impl;

import com.sh.common.vo.R;
import com.sh.lmd.server.user.point.dao.TPrizelogMapper;
import com.sh.lmd.server.user.point.service.TPrizelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TPrizelogServiceImpl implements TPrizelogService {
    @Autowired
    private TPrizelogMapper prizelogMapper;
    @Override
    public R queryPrizelogByUserId(int userId) {
        System.out.println(userId + "+++++++++++++++++++++++++++++");
        return R.setOK("OK", prizelogMapper.queryPrizelogByUserId(userId));
    }

    @Override
    public R queryAllPrizelog() {
        return R.setOK("OK", prizelogMapper.queryAllPrizelog());
    }
}
