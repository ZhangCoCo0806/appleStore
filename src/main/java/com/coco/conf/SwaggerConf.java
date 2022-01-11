package com.coco.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConf {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("张世琪哈哈哈")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coco.controller"))//指定要扫描的包
                .build();
    }


    public ApiInfo apiInfo(){
        return new ApiInfo(
                "apple二手交易网站的接口api",
                "制作者:张世琪",
                "CoCo1.0",
                "https://www.yezismile.com/",
                new Contact("张世琪","https://www.yezismile.com/","2231925844@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
