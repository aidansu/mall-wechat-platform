package com.aidansu.mall.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 小程序登录DTO
 *
 * @author aidansu
 */
@Data
@Builder
public class WechatUserLoginDTO {

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private String tenantId;
    /**
     * code
     */
    @NotBlank(message = "code不能为空")
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
}
