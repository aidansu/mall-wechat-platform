package com.aidansu.mall.gateway.config;

import com.aidansu.mall.gateway.props.RouteProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger聚合文档配置
 *
 * @author aidan
 */
@Configuration
@EnableConfigurationProperties(RouteProperties.class)
public class SwaggerRouteConfiguration {
}
