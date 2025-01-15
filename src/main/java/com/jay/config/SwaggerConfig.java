package com.jay.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: swagger2 的配置
 * @author liangning
 * @date 2019/11/27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private static final String VERSION = "1.0.0-SNAPSHOT";
    private static final String BASE_PACKAGE = "com.jay";

    @Bean
    public Docket api() {
        Predicate<String> predicate = null;
        predicate = PathSelectors.any();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(predicate).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring-session测试").description("restful 风格接口").version(VERSION).build();
    }
}
