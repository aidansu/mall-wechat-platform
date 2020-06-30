package com.aidansu.mall.user.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置信息
 *
 * @author aidan
 */
@Data
@ConfigurationProperties(prefix = "wechat")
@Component
public class WechatAccountConfig {

    /**
     * 小程序appId
     * 获取地址 https://mp.weixin.qq.com
     */
    private String miniAppId;

    /**
     * 小程序appSecret
     */
    private String miniAppSecret;

}
