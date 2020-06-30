package com.aidansu.mall.auth.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统版本 控制器
 *
 * @author aidan
 */
@RestController
@Api(value = "系统版本", tags = "系统版本")
public class VersionController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${spring.application.version: }")
	private String version;

	@Value("${spring.profiles.active}")
	private String active;

	@GetMapping(value = "/version")
	public String version() {
		return applicationName+"："+version+" "+active;
	}

}
