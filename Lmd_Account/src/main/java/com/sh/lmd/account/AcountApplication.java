package com.sh.lmd.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dks
 * @date 2019/6/27 17:49
 */
@SpringBootApplication
@EnableEurekaClient //服务提供者
@EnableTransactionManagement  //开启事务管理器
public class AcountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcountApplication.class,args);
    }
}
