package com.sh.lmd.server.power.service;

import com.sh.common.vo.R;

public interface TInviteService {

    /**
     * 根据用户id查找邀请
     * @param token
     * @return
     */
    R findInviteByUid(String token);

    /**
     * 根据用户id查询用户的邀请用户
     * @param token
     * @return
     */
    R findInviteUser(String token);
}
