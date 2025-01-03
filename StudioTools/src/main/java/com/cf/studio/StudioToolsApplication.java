package com.cf.studio;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.cf.studio")
@MapperScan({"com.cf.studio.mapper"})
public class StudioToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudioToolsApplication.class, args);
    }

}
