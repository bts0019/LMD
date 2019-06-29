package com.sh.lmd.server.service;

import com.sh.common.vo.R;

public interface LoginService {
    //实现登录
    R login(String phone,String password);
    //校验登录有效性
    R checkLogin(String token);
    //注销
    R exitLogin(String token);
}
