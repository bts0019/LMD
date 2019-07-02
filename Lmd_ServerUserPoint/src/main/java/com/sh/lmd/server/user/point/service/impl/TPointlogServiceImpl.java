package com.sh.lmd.server.user.point.service.impl;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TPointlog;
import com.sh.lmd.server.user.point.dao.TPointlogMapper;
import com.sh.lmd.server.user.point.service.TPointlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TPointlogServiceImpl implements TPointlogService {
    @Autowired
    private TPointlogMapper pointlogMapper;

    @Override
    public R queryPointlog(int userId, int way) {
        return R.setOK("OK", pointlogMapper.queryAll(userId, way));
    }

    @Override
    public R savePointlog(TPointlog tPointlog) {
        pointlogMapper.savePointlog(tPointlog);
        return R.setOK();
    }

    @Override
    public R queryMonthLog(int userId) {
//        LoginToken loginToken = UserTokenUtil.parseToken(JwtUtil.parseJWT(token));
        return R.setOK("OK", pointlogMapper.queryMonthLog(userId));
    }


}
