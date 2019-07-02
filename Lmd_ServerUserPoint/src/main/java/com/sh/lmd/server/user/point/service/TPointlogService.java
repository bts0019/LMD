package com.sh.lmd.server.user.point.service;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TPointlog;

public interface TPointlogService {

    R queryPointlog(int userId, int way);
    R savePointlog(TPointlog tPointlog);
    R queryMonthLog(int userId);
}
