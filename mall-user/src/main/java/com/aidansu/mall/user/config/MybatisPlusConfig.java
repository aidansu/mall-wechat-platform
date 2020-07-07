package com.aidansu.mall.user.config;

import com.aidansu.mall.core.constant.CommonConstant;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Mybatis-plus 配置
 *
 * @author aidansu
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    @ConditionalOnMissingBean(PaginationInterceptor.class)
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 打印 SQL 执行语句
     */
    @Bean
    @Profile({CommonConstant.DEV_CODE, CommonConstant.TEST_CODE})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}

