package com.junmo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: sucf
 * @date: 2022/4/4 16:01
 * @description:
 */
@SpringBootApplication
@MapperScan("com.junmo.web.mapper")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
