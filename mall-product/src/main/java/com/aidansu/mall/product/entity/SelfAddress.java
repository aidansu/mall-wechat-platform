package com.aidansu.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.aidansu.mall.core.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 自提地址 实体类
 *
 * @author aidan
 * @since 2019-07-09
 */
@Data
@TableName("mall_self_address")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SelfAddress对象", description = "自提地址")
public class SelfAddress extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 店名
     */
    @ApiModelProperty(value = "店名")
    private String storeName;
    /**
     * 店铺地址
     */
    @ApiModelProperty(value = "店铺地址")
    private String storeAddress;
    /**
     * 营业时间
     */
    @ApiModelProperty(value = "营业时间")
    private String businessHours;


}
