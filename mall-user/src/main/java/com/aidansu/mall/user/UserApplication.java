package com.aidansu.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author aidan
 */
@SpringBootApplication(scanBasePackages = {"com.aidansu.mall"})
@MapperScan(basePackages = "com.aidansu.mall.user.dao")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
