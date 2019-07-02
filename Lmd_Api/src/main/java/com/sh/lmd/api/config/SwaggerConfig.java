package com.sh.lmd.api.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration // 标注这是一个注解
public class SwaggerConfig {


    public ApiInfo createInfo(){

        ApiInfo info = new ApiInfoBuilder().title("利民贷-数据接口平台").
                contact(new Contact("LMD","http://dks_hello.com","dks_hello@163.com")).
                description("实现一个利民贷项目的数据接口").build();
        return info;
    }

    public Docket createDocket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(createInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.sh.lmd.api")).build();
        return docket;
    }

}
