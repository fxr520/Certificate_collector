package com.fxr.certificate_collector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** swagger2配置类
 * @author fanXiaoRui
 * @date 2020/11/23 15:07
 */
@Configuration      //让Spring来加载该类配置
@EnableSwagger2     // 开启Swagger2的自动配置
public class SwaggerConfig {

    //配置docket以配置Swagger具体参数
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 文档信息
                .apiInfo(apiInfo())

                // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .select()

                // 根据包路径扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.fxr.certificate_collector.controller"))
                .build();
    }

    //配置Swagger信息-apiInfo
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("FXR的Swagger2API文档")
                .description("喜编程,爱记录,乐分享")
                .termsOfServiceUrl("http://47.95.119.22:9022")
                .contact(new Contact("FXR", "http://47.95.119.22:9022", "2816077466@qq.com"))
                .version("1.0.0")
                .build();
    }

}
