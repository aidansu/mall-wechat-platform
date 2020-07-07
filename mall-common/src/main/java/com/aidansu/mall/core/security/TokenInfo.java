package com.aidansu.mall.core.security;

import lombok.Data;

/**
 * TokenInfo
 *
 * @author aidan
 */
@Data
public class TokenInfo {

    /**
     * 令牌值
     */
    private String token;

    /**
     * 过期秒数
     */
    private int expire;

    /**
     * 授权范围
     */
    private String scope;

}
