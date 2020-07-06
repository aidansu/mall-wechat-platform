package com.aidansu.mall.gateway.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由配置类
 *
 * @author aidan
 */
@Data
@ConfigurationProperties("mall.document")
public class RouteProperties {

	private final List<RouteResource> resources = new ArrayList<>();

}
