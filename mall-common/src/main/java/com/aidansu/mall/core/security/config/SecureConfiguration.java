package com.aidansu.mall.core.security.config;

import com.aidansu.mall.core.security.interceptor.SecureInterceptor;
import com.aidansu.mall.core.security.props.SecureProperties;
import com.aidansu.mall.core.security.registry.SecureRegistry;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 安全配置类
 *
 * @author aidan
 */
@Order
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties({SecureProperties.class})
public class SecureConfiguration implements WebMvcConfigurer {

    private final SecureRegistry secureRegistry;

    private final SecureProperties secureProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        if (secureRegistry.isEnable()) {
            registry.addInterceptor(new SecureInterceptor())
                    .excludePathPatterns(secureRegistry.getExcludePatterns())
                    .excludePathPatterns(secureRegistry.getDefaultExcludePatterns())
                    .excludePathPatterns(secureProperties.getExcludePatterns());
        }
    }


}
