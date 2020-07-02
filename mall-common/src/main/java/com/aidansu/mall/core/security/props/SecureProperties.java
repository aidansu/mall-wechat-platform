package com.aidansu.mall.core.security.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * secure放行额外配置
 *
 * @author aidan
 */
@Data
@ConfigurationProperties("mall.secure.url")
public class SecureProperties {

	private final List<String> excludePatterns = new ArrayList<>();

}
