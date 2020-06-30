package com.aidansu.mall.auth.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 用户登录 DTO
 *
 * @author aidan
 */
@Data
@Builder
public class UserLoginDTO {

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private String tenantId;
    /**
     * code
     */
    @ApiModelProperty(value = "code")
    private String code;
    /**
     * 微信昵称
     */
    @ApiModelProperty(value = "微信昵称")
    private String nickname;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;
    /**
     * 语言
     */
    @ApiModelProperty(value = "语言")
    private String language;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String avatarUrl;
    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    private String phone;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
}
