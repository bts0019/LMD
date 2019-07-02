package com.sh.common.config;

public class ProjectConfig {
    public static final String SIGNKEY="usign:lmd";//记录每天答题  Set集合 内容 手机号

    //Redis信息
    public static final String REDISHOST="39.105.189.141";
    public static final int REDISPORT=6380;
    public static final String REDISPASS="qfjava";

    //JWT的签名算法
    public static final String JWTSIGN="SHA256";
    public static final int JWTTIME=30;//令牌的有效期
    public static final String JWTKEY="qfjava_lmd";
}
