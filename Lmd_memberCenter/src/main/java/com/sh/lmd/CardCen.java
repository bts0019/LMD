package com.sh.lmd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sh.lmd.dao")
@EnableSwagger2
public class CardCen {

    public static void main(String[] args) {
        SpringApplication.run(CardCen.class,args);
    }
}
