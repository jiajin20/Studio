package com.cf.studio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/**
 * 添加Swagger全局认证按钮
 * @author Yoooum
 */
@Configuration
public class SwaggerAuthorization {

    /**
     * 添加全局认证，配置OpenAPI规范
     * @return
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .schemaRequirement(HttpHeaders.AUTHORIZATION, this.securityScheme())
                .addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                .info(new Info().title("StudioTools")
                        .description("cf")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("cf").url("")));
    }

    /**
     * 配置认证信息,swagger安全方案
     * @return
     */
    private SecurityScheme securityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP) // 设置认证方式
                .scheme("Bearer") // 方案bearer
                .bearerFormat("JWT") // 格式JWT
                .name(HttpHeaders.AUTHORIZATION) // 认证名称
                .in(SecurityScheme.In.HEADER); // 认证位置
    }
}
