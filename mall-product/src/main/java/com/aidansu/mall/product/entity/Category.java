package com.aidansu.mall.product.entity;

import com.aidansu.mall.core.mybatis.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  商品类别 实体类
 *
 * @author aidan
 */
@Data
@TableName("mall_category")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Category对象", description = "Category对象")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private String tenantId;
    /**
     * 父类别id当id=0时说明是根节点,一级类别
     */
    @ApiModelProperty(value = "父类别id当id=0时说明是根节点,一级类别")
    private Long parentId;
    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String name;
    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    @ApiModelProperty(value = "排序编号,同类展示顺序,数值相等则自然排序")
    private Integer sort;


}
