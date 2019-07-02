package com.sh.lmd.server.power;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  // 开启事务
@EnableEurekaClient  // 服务提供者
@MapperScan("com.sh.lmd.server.power.dao")
public class UserPowerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserPowerServerApplication.class,args);
    }
}
