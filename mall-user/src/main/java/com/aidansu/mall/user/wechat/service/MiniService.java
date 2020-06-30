package com.aidansu.mall.user.wechat.service;

import com.aidansu.mall.user.wechat.entity.UserSession;

/**
 * 小程序服务端
 *
 * @author aidansu
 */
public interface MiniService {

    /**
     * 登录凭证校验
     *
     * @param code 登录凭证
     * @return UserSession
     */
    UserSession code2Session(String code);
}
