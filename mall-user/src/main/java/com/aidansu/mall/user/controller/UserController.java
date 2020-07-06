package com.aidansu.mall.user.controller;

import com.aidansu.mall.core.api.R;
import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.security.AuthUserDetails;
import com.aidansu.mall.core.security.auth.PreAuth;
import com.aidansu.mall.core.security.exception.SecureException;
import com.aidansu.mall.core.security.utils.JwtTokenUtil;
import com.aidansu.mall.user.dto.AdminUserLoginDTO;
import com.aidansu.mall.user.dto.WechatUserLoginDTO;
import com.aidansu.mall.user.entity.User;
import com.aidansu.mall.user.service.IUserService;
import com.aidansu.mall.user.vo.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collections;

/**
 * 用户控制器
 *
 * @author aidan
 */
@RestController
@RequestMapping("/users")
@Slf4j
@Api(value = "用户信息", tags = "用户信息")
public class UserController {

    @Resource
    private IUserService userService;

    @PreAuth("ROLE_ADMIN")
    @GetMapping("/{id}")
    @ApiOperation(value = "通过id获取用户信息", notes = "传入主键id")
    public R<User> findById(@PathVariable Long id) {
        return R.data(this.userService.findById(id));
    }

    @PreAuth("ROLE_ADMIN")
    @GetMapping("/mini-openid/{openid}")
    @ApiOperation(value = "通过小程序openid获取用户信息", notes = "传入小程序openid")
    public R<User> findByOpenid(@PathVariable String openid) {
        return R.data(this.userService.findByMiniOpenid(openid));
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入小程序openid")
    public R<User> detail() {
        // 通过token获取用户ID，再通过用户ID获取用户详细信息
        AuthUserDetails jwtUser = JwtTokenUtil.getUser();
        if(jwtUser == null){
            throw new SecureException(ResultCode.UN_AUTHORIZED);
        }
        User user = userService.findById(jwtUser.getUserId());
        return R.data(user);
    }

    @PostMapping("/login/mini")
    @ApiOperation(value = "小程序登录", notes = "传入code")
    public R<UserInfoVO> loginByMini(@Valid @RequestBody WechatUserLoginDTO wechatUserLoginDTO){
        log.info("/login/mini ==> {}",wechatUserLoginDTO);
        User user =  this.userService.loginByMini(wechatUserLoginDTO);
        return R.data(UserInfoVO.builder()
                    .id(user.getId())
                    .miniOpenid(user.getMiniOpenid())
                    .phone(user.getPhone())
                    .nickName(user.getNickName())
                    .avatar(user.getAvatar())
                    .tenantId(user.getTenantId())
                    .authorities(Collections.singletonList("ROLE_USER"))
                    .build()
        );
    }

    @PostMapping("/login/username")
    @ApiOperation(value = "用户名密码登录", notes = "传入tenantId,username,password")
    public R<UserInfoVO> loginByUsername(@Valid @RequestBody AdminUserLoginDTO adminUserLoginDTO){
        log.info("/login/username ==> {}",adminUserLoginDTO);
        User user =  this.userService.loginByUsername(adminUserLoginDTO);
        return R.data(UserInfoVO.builder()
                .id(user.getId())
                .miniOpenid(user.getMiniOpenid())
                .phone(user.getPhone())
                .nickName(user.getNickName())
                .avatar(user.getAvatar())
                .tenantId(user.getTenantId())
                .authorities(Collections.singletonList("ROLE_ADMIN"))
                .build());
    }

}
