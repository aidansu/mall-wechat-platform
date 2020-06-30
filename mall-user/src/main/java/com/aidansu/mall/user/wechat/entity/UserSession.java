package com.aidansu.mall.user.wechat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登录凭证校验
 *
 * @author aidansu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {

    /**
     * openid
     */
    @ApiModelProperty(value = "openid")
    private String openid;
    /**
     * session_key
     */
    @ApiModelProperty(value = "session_key")
    @JsonProperty("session_key")
    private String sessionKey;
    /**
     * unionid
     */
    @ApiModelProperty(value = "unionid")
    private String unionid;
    /**
     * errcode
     */
    @ApiModelProperty(value = "errcode")
    private Integer errcode;
    /**
     * errmsg
     */
    @ApiModelProperty(value = "errmsg")
    private String errmsg;


}
