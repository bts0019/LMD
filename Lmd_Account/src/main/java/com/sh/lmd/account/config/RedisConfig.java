package com.sh.lmd.account.config;

import com.sh.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dks
 * @date 2019/6/27 20:40
 */

@Configuration
public class RedisConfig {

    @Bean
    public JedisUtil createJU(){
        return JedisUtil.getInstance();
    }

}
