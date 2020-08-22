package com.aidansu.mall.auth.utils;

import com.aidansu.mall.core.constant.TokenConstant;
import com.aidansu.mall.auth.entity.AuthInfo;
import com.aidansu.mall.auth.entity.UserInfo;
import com.aidansu.mall.core.security.JwtTokenUtil;
import com.aidansu.mall.core.security.TokenInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证工具类
 *
 * @author aidan
 */
public class TokenUtil {

    /**
     * 创建认证token
     *
     * @param userInfo 用户信息
     * @return token
     */
    public static AuthInfo createAuthInfo(UserInfo userInfo) {

        //设置jwt参数
        Map<String, Object> param = new HashMap<>(16);
        param.put(TokenConstant.TOKEN_TYPE, TokenConstant.ACCESS_TOKEN);
        param.put(TokenConstant.TENANT_ID, userInfo.getTenantId());
        param.put(TokenConstant.USER_ID, String.valueOf(userInfo.getId()));
        param.put(TokenConstant.NICK_NAME, userInfo.getNickName());
        param.put(TokenConstant.AUTHORITIES, userInfo.getAuthorities());

        TokenInfo accessToken = JwtTokenUtil.createJWT(param, TokenConstant.ACCESS_TOKEN);
        AuthInfo authInfo = new AuthInfo();
        authInfo.setMiniOpenid(userInfo.getMiniOpenid());
        authInfo.setNickName(userInfo.getNickName());
        authInfo.setAvatar(userInfo.getAvatar());
        authInfo.setAccessToken(accessToken.getToken());
        authInfo.setExpiresIn(accessToken.getExpire());
        authInfo.setRefreshToken(createRefreshToken(userInfo).getToken());
        authInfo.setTokenType(TokenConstant.BEARER);
        authInfo.setTenantId(userInfo.getTenantId());
        authInfo.setUserId(userInfo.getId());
        authInfo.setScope(accessToken.getScope());
        return authInfo;
    }

    /**
     * 创建refreshToken
     *
     * @param userInfo 用户信息
     * @return refreshToken
     */
    private static TokenInfo createRefreshToken(UserInfo userInfo) {
        Map<String, Object> param = new HashMap<>(16);
        param.put(TokenConstant.TOKEN_TYPE, TokenConstant.REFRESH_TOKEN);
        param.put(TokenConstant.USER_ID, String.valueOf(userInfo.getId()));
        return JwtTokenUtil.createJWT(param, TokenConstant.REFRESH_TOKEN);
    }

}
