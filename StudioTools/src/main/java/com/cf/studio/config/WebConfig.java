package com.cf.studio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置跨域规则，限定前端的地址
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")  // 仅允许指定的前端地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Authorization", "Content-Disposition"); // 暴露特定的响应头
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射静态资源路径，但不覆盖 Swagger UI 的路径
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/", "file:" + System.getProperty("user.dir") + "/static/img/");

        // 映射 Swagger UI 资源
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");  // Swagger UI 资源
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("")  // 拦截所有请求
                .excludePathPatterns(
                        //资源路径
                        "/static/**",  "/static/**","/","/static/",
                        "/doc.html", "/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs", "/webjars/**","/resources/**",
                        //页面跳转
                        "/login","/index",
                        //接口路径
                        "/user/login","/user/register","/user/verifyCode","user/getCode","user/getUserById"

                );
    }
}
