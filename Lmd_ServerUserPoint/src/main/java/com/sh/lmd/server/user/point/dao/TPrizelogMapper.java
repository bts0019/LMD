package com.sh.lmd.server.user.point.dao;

import com.sh.lmd.entity.TPrizelog;
import com.sh.lmd.server.user.point.vo.AllUserPrizelog;
import com.sh.lmd.server.user.point.vo.VPrizelog;

import java.util.List;

public interface TPrizelogMapper {
    List<VPrizelog> queryPrizelogByUserId(int userId);
    List<AllUserPrizelog> queryAllPrizelog();
    void save(TPrizelog tPrizelog);

}
