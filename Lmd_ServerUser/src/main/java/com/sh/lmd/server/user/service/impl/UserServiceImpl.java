package com.sh.lmd.server.user.service.impl;

import com.sh.common.config.ProjectConfig;
import com.sh.common.exception.UserException;
import com.sh.common.util.EncryptionUtil;
import com.sh.common.vo.R;
import com.sh.lmd.entity.TUser;
import com.sh.lmd.server.user.dao.TUserMapper;
import com.sh.lmd.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private TUserMapper userMapper;

    @Override
    @Transactional(rollbackFor = {UserException.class})
    public R save(TUser user) throws UserException {
        try{
            user.setPassword(EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI,user.getPassword()));
            //新增用户
            userMapper.insert(user);
        }catch (Exception e){
            throw new UserException("用户注册异常:"+e.getMessage());
        }

        return R.setOK();
    }

    @Override
    public R all() {
        return R.setOK("ok",userMapper.all());
    }
}
