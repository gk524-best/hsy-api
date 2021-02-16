package com.hsy.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后台启动类
 */
@SpringBootApplication(scanBasePackages = {"com.hsy.manager","com.hsy.common"})
@MapperScan("com.hsy.manager.mapper")
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
