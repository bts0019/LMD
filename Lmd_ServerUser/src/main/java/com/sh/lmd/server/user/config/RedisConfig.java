package com.sh.lmd.server.user.config;


import com.sh.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/6/13 11:35
 */
@Configuration
public class RedisConfig {
    @Bean
    public JedisUtil createJU(){
        return JedisUtil.getInstance();
    }
}
