package com.sh.lmd.server.user.service;

import com.sh.common.exception.UserException;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TUser;



public interface UserService {
    R save(TUser user) throws UserException;
    R all();
}
