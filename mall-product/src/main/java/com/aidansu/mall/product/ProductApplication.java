package com.aidansu.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author aidan
 */
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.aidansu.mall"})
@MapperScan(basePackages = "com.aidansu.mall.product.dao")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
