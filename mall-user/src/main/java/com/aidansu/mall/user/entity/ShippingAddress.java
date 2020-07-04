package com.aidansu.mall.user.entity;

import com.aidansu.mall.core.constant.CommonConstant;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 收货地址 实体类
 *
 * @author aidan
 */
@Data
@TableName("mall_shipping_address")
@ApiModel(value = "ShippingAddress对象", description = "ShippingAddress对象")
public class ShippingAddress {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String receiverName;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String receiverPhone;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;
    /**
     * 区/县
     */
    @ApiModelProperty(value = "区/县")
    private String district;
    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String postcode;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;
    /**
     * 地址标签
     */
    @ApiModelProperty(value = "地址标签")
    private String addressTag;
    /**
     * 默认地址1-是，0-不是
     */
    @ApiModelProperty(value = "默认地址1-是，0-不是")
    private Integer defaultStatus;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
    /**
     * 状态[0:未删除,1:删除]
     */
    @TableLogic
    @ApiModelProperty(value = "是否已删除")
    private Integer isDeleted;


}
