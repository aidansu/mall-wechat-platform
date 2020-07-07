package com.aidansu.mall.core.constant;

/**
 * Token配置常量
 *
 * @author aidan
 */
public interface TokenConstant {

    /**
     * JWT 密钥
     */
    String SIGN_KEY = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * access token 有效时间为一周
     */
    Long EXPIRES_IN_ACCESS = 604800L;
    /**
     * refresh token 有效时间为两周
     */
    Long EXPIRES_IN_REFRESH = 1209600L;

    String HEADER = "Authorization";
    String BEARER = "bearer";
    Integer AUTH_LENGTH = 7;

    String ACCESS_TOKEN = "access_token";
    String REFRESH_TOKEN = "refresh_token";
    String TOKEN_TYPE = "token_type";
    String EXPIRES_IN = "expires_in";
    String AUTHORITIES = "authorities";
    String TENANT_ID = "tenant_id";
    String USER_ID = "user_id";
    String NICK_NAME = "nick_name";
    String AVATAR = "avatar";

}
