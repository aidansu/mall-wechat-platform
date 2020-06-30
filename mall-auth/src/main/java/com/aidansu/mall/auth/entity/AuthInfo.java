package com.aidansu.mall.auth.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 认证用户信息 实体类
 *
 * @author aidan
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthInfo {

    @ApiModelProperty(value = "令牌")
    @JsonProperty("access_token")
    private String accessToken;

    @ApiModelProperty(value = "令牌类型")
    @JsonProperty("token_type")
    private String tokenType;

    @ApiModelProperty(value = "刷新令牌")
    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("expires_in")
    @ApiModelProperty(value = "过期时间")
    private long expiresIn;

    @ApiModelProperty(value = "授权范围")
    private String scope;

    @ApiModelProperty(value = "租户ID")
    @JsonProperty("tenant_id")
    private String tenantId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "用户ID")
    @JsonProperty("user_id")
    private long userId;

    @ApiModelProperty(value = "小程序openid")
    private String miniOpenid;

    @ApiModelProperty(value = "昵称")
    @JsonProperty("nick_name")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String avatar;

}
