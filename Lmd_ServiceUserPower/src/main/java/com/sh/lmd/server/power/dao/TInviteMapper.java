package com.sh.lmd.server.power.dao;

import com.sh.lmd.server.power.po.MyInvitePo;
import com.sh.lmd.server.power.po.MyInviteUserPo;

import java.util.List;

public interface TInviteMapper {
    /**
     * 查找我的邀请信息
     * @param uid
     * @return
     */
    MyInvitePo selectInviteByUid(Integer uid);

    /**
     * 根据用户查询当前用户邀请的用户
     * @param uid
     * @return
     */
    List<MyInviteUserPo> selectInviteUser(Integer uid);
}
