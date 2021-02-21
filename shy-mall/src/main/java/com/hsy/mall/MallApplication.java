package com.hsy.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 * @author zhangbingbing
 * @date 2021/2/16 下午6:54
 */
@SpringBootApplication(scanBasePackages = {"com.hsy.mall", "com.hsy.common"})
@MapperScan("com.hsy.mall.mapper")
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}
