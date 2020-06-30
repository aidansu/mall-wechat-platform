package com.aidansu.mall.auth.feign;

import com.aidansu.mall.auth.dto.UserLoginDTO;
import com.aidansu.mall.auth.entity.UserInfo;
import com.aidansu.mall.auth.feign.fallbackfactory.UserClientFallbackFactory;
import com.aidansu.mall.core.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息 远程调用客户端
 *
 * @author aidan
 */
@FeignClient(name = "mall-user", fallbackFactory = UserClientFallbackFactory.class)
public interface IUserClient {

    /**
     * 小程序用户登录
     *
     * @param dto 小程序用户信息
     * @return R<UserInfo>
     */
    @PostMapping("/users/login/mini")
    R<UserInfo> loginByMini(@RequestBody UserLoginDTO dto);

    /**
     * 管理员用户登录
     *
     * @param dto 管理员用户信息
     * @return R<UserInfo>
     */
    @PostMapping("/users/login/username")
    R<UserInfo> loginByUsername(@RequestBody UserLoginDTO dto);
}
