package com.sh.lmd.server.user.point.dao;

import com.sh.lmd.entity.TPointlog;

import java.util.List;

public interface TPointlogMapper {
    List<TPointlog> queryAll(int userId, int way);
    void savePointlog(TPointlog tPointlog);
    List<TPointlog> queryMonthLog(int userId);


}
