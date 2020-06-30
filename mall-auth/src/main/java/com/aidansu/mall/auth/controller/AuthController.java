package com.aidansu.mall.auth.controller;

import com.aidansu.mall.core.api.R;
import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.constant.ApisConstant;
import com.aidansu.mall.core.error.ApisException;
import com.aidansu.mall.auth.dto.UserLoginDTO;
import com.aidansu.mall.auth.entity.AuthInfo;
import com.aidansu.mall.auth.entity.UserInfo;
import com.aidansu.mall.auth.feign.IUserClient;
import com.aidansu.mall.auth.utils.TokenUtil;
import com.aidansu.mall.core.security.exception.SecureException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 认证授权 控制器
 *
 * @author aidansu
 */
@RestController
@RequestMapping("/auth")
@Slf4j
@Api(value = "认证授权", tags = "认证授权接口")
public class AuthController {

    @Resource
    private IUserClient userClient;

    @PostMapping("/token")
    public AuthInfo login(@Valid @RequestBody UserLoginDTO dto){
        log.info("/token ==> {}",dto);
        R<UserInfo> userInfoDate;
        // 判断登录的类型
        if(StringUtils.isNotBlank(dto.getCode())) {
            userInfoDate = this.userClient.loginByMini(dto);
        }else if(StringUtils.isNotBlank(dto.getUsername()) && StringUtils.isNotBlank(dto.getPassword())){
            userInfoDate = this.userClient.loginByUsername(dto);
        }else{
            throw new SecureException(ResultCode.PARAM_MISS);
        }
        // 判断是否有数据返回和返回的数据是否成功
        if(userInfoDate == null){
            throw new ApisException(ApisConstant.LOGIN_FAILED);
        }
        if(userInfoDate.getStatus() != HttpServletResponse.SC_OK){
            throw new ApisException(userInfoDate.getMessage());
        }

        UserInfo userInfo = userInfoDate.getData();
        // 判断是否获取到用户信息
        if(userInfo == null){
            throw new ApisException(ApisConstant.LOGIN_FAILED);
        }
        // 判断该用户是否已经登录过
        if(StringUtils.isBlank(userInfo.getNickName())){
            throw new ApisException(ApisConstant.PLEASE_LOGIN_FIRST);
        }

        AuthInfo authInfo = TokenUtil.createAuthInfo(userInfo);

        log.info(
                "用户{}登录成功，生成的token = {}, 有效期到:{}",
                authInfo.getNickName(),
                authInfo.getAccessToken(),
                authInfo.getExpiresIn()
        );
        return authInfo;
    }

}
