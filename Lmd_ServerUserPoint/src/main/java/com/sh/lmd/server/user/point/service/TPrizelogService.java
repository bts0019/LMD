package com.sh.lmd.server.user.point.service;

import com.sh.common.vo.R;

public interface TPrizelogService {
    R queryPrizelogByUserId(int userId);
    R queryAllPrizelog();

}
