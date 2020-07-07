package com.aidansu.mall.core.security.registry;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * secure api放行配置
 *
 * @author aidan
 */
@Data
public class SecureRegistry {

    private boolean enable = true;

    private final List<String> defaultExcludePatterns = new ArrayList<>();

    private final List<String> excludePatterns = new ArrayList<>();

    public SecureRegistry() {
        this.defaultExcludePatterns.add("/actuator/health/**");
        this.defaultExcludePatterns.add("/v2/api-docs/**");
        this.defaultExcludePatterns.add("/v2/api-docs-ext/**");
        this.defaultExcludePatterns.add("/doc.html");
        this.defaultExcludePatterns.add("/js/**");
        this.defaultExcludePatterns.add("/webjars/**");
        this.defaultExcludePatterns.add("/swagger-resources/**");
        this.defaultExcludePatterns.add("/css/**");
        this.defaultExcludePatterns.add("/img/**");
        this.defaultExcludePatterns.add("/favicon.ico");
        this.defaultExcludePatterns.add("/fonts/**");
        this.defaultExcludePatterns.add("/error/**");
        this.defaultExcludePatterns.add("/assets/**");
        this.defaultExcludePatterns.add("/version");
        this.defaultExcludePatterns.add("/auth/**");
    }

    /**
     * 设置放行api
     */
    public SecureRegistry excludePathPatterns(String... patterns) {
        return excludePathPatterns(Arrays.asList(patterns));
    }

    /**
     * 设置放行api
     */
    public SecureRegistry excludePathPatterns(List<String> patterns) {
        this.excludePatterns.addAll(patterns);
        return this;
    }

}
