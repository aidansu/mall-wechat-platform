package com.aidansu.mall.core.security.config;

import com.aidansu.mall.core.security.registry.SecureRegistry;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * secure注册默认配置
 *
 * @author aidan
 */
@Order
@Configuration
@AutoConfigureBefore(SecureConfiguration.class)
public class RegistryConfiguration {

    @Bean
    @ConditionalOnMissingBean(SecureRegistry.class)
    public SecureRegistry secureRegistry() {
        return new SecureRegistry();
    }

}
