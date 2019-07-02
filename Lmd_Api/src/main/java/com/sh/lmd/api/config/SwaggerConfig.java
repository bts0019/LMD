package com.sh.lmd.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *@Author feri
 *@Date Created in 2019/6/3 14:45
 * Swagger设置
 */
@Configuration //标记这是一个配置
@ComponentScan(basePackages = {"com.sh.lmd.api.controller"})
public class SwaggerConfig {
    /**
     * 创建API的基本信息（这些基本信息会展示在文档页面中）
     * 访问地址： http://项目实际地址/swagger-ui.html
     * */
    public ApiInfo createA(){
        ApiInfo info=new ApiInfoBuilder().title("利民贷-数据接口平台").
                description("实现利民贷项目的数据接口").build();
        return info;
    }
    /**
     * 创建API应用
     * appinfo()增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例，
     * 用来控制那些接口暴露给Swagger来展现
     * 采用置顶扫描的包路径来定义指定要建立API的目录
     */
    @Bean//创建对象  修饰方法 方法的返回值必须是引用类型  对象存储在IOC容器
    public Docket createDocket(){
       Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(createA()).select().
               apis(RequestHandlerSelectors.basePackage("com.sh.lmd.api.controller")).
               build();
       return docket;
    }
}