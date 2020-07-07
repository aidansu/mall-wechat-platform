package com.aidansu.mall.core.security;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * jwt用户实体
 *
 * @author aidan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty(hidden = true)
    private Long userId;
    /**
     * 租户ID
     */
    @ApiModelProperty(hidden = true)
    private String tenantId;
    /**
     * 昵称
     */
    @ApiModelProperty(hidden = true)
    private String nickName;
    /**
     * 角色权限
     */
    @ApiModelProperty(hidden = true)
    private List<String> authorities;

}
