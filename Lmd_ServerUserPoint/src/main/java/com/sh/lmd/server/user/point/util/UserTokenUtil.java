package com.sh.lmd.server.user.point.util;

import com.alibaba.fastjson.JSON;
import com.sh.common.model.LoginToken;
import com.sh.lmd.entity.TUser;

public class UserTokenUtil {
    public static LoginToken parseToken(String json){
        if(json!=null){
            return JSON.parseObject(json,LoginToken.class);
        }else {
            return null;
        }
    }
    public static int parseTokenId(String json){
        if(json!=null){
            LoginToken user= JSON.parseObject(json,LoginToken.class);
            return user.getUid();
        }else {
            return 0;
        }
    }
    public static TUser parseUserToken(String json){
        if(json!=null){
            return JSON.parseObject(json,TUser.class);
        }else {
            return null;
        }
    }
    public static int parseUid(String json){
        if(json!=null){
            TUser user= JSON.parseObject(json,TUser.class);
            return user.getUserid();
        }else {
            return 0;
        }
    }
}
