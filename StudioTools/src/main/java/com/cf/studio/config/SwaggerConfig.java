package com.cf.studio.config;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi//会自动开启配置，启动类不需要加任何注解
@EnableSwaggerBootstrapUI//访问美化，方便查看调试
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        //Docket: 摘要对象，通过对象配置 描述文件的信息
        Docket docket = new Docket(DocumentationType.OAS_30);
        docket.apiInfo(myApiInfo())
                //select()：返回ApiSelectorBuilder对象，通过对象调用build()可以创建Docket对象
                .select()
                // 指定要扫描/维护接口文档的包（否则就全部扫描）
                .apis(RequestHandlerSelectors.basePackage("com.cf.studio.controller"))
                // 路径过滤：该Docket-UI展示时，只展示指定路径下的接口文档(any表示都展示)
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    // 接口文档的概要信息，返回ApiInfo对象
    private ApiInfo myApiInfo(){
        //标题
        String title = "工作室管理接口文档";
        //简单描述
        String description = "关于工作室的基本功能";
        //版本
        String version = "V1.0.0";
        // url接口路径前缀
        String termsOfServiceUrl = "/";
        //作者信息
        Contact contact = new Contact("CF","","3196117119@qq.com");
        //协议
        String license = "The Apache License";
        //协议url
        String licenseUrl = "";

        ApiInfo apiInfo =  new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(contact)
                .license(license)
                .licenseUrl(licenseUrl)
                .build();
        return apiInfo;
    }

}