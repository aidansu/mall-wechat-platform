package com.aidansu.mall.user.entity;

import com.aidansu.mall.core.constant.CommonConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 用户 实体类
 *
 * @author aidan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty("主键id")
	private Long id;
	/**
	 * 租户ID
	 */
	@ApiModelProperty(value = "租户ID")
	private String tenantId;
	/**
	 * unionid
	 */
	@ApiModelProperty(value = "unionid")
	private String unionid;
	/**
	 * 小程序openid
	 */
	@ApiModelProperty(value = "小程序openid")
	private String miniOpenid;
	/**
	 * session_key
	 */
	@JsonIgnore
	private String sessionKey;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;
	/**
	 * 密码
	 */
	@JsonIgnore
	private String password;
	/**
	 * 昵称
	 */
	@ApiModelProperty(value = "昵称")
	private String nickName;
	/**
	 * 真名
	 */
	@ApiModelProperty(value = "真名")
	private String realName;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String email;
	/**
	 * 手机
	 */
	@ApiModelProperty(value = "手机")
	private String phone;
	/**
	 * 生日
	 */
	@DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@ApiModelProperty(value = "生日")
	private LocalDateTime birthday;
	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	private Integer gender;
	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像")
	private String avatar;
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
	private String county;
	/**
	 * 语言
	 */
	@ApiModelProperty(value = "语言")
	private String language;
	/**
	 * 最后一次登录时间
	 */
	@DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	private LocalDateTime lastLoginTime;
	/**
	 * 创建人
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "创建人")
	private Long createUser;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;
	/**
	 * 更新人
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "更新人")
	private Long updateUser;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;
	/**
	 * 状态[1:正常]
	 */
	@ApiModelProperty(value = "业务状态")
	private Integer status;
	/**
	 * 状态[0:未删除,1:删除]
	 */
	@ApiModelProperty(value = "是否已删除")
	private Integer isDeleted;
}
