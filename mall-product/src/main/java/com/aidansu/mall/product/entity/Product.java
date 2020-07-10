package com.aidansu.mall.product.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.aidansu.mall.core.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品 实体类
 *
 * @author aidan
 * @since 2020-07-10
 */
@Data
@TableName("mall_product")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Product对象", description = "商品")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 分类id,对应mall_category表的主键
     */
    @ApiModelProperty(value = "分类id,对应mall_category表的主键")
    private Long categoryId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;
    /**
     * 商品副标题
     */
    @ApiModelProperty(value = "商品副标题")
    private String subtitle;
    /**
     * 产品主图,url相对地址
     */
    @ApiModelProperty(value = "产品主图,url相对地址")
    private String mainImage;
    /**
     * 图片地址,json格式,扩展用
     */
    @ApiModelProperty(value = "图片地址,json格式,扩展用")
    private String subImages;
    /**
     * 商品详情
     */
    @ApiModelProperty(value = "商品详情")
    private String detail;
    /**
     * 价格,单位-元保留两位小数
     */
    @ApiModelProperty(value = "价格,单位-元保留两位小数")
    private BigDecimal price;
    /**
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量")
    private Integer stock;
    /**
     * 是否热门：0=默认,1=热门
     */
    @ApiModelProperty(value = "是否热门：0=默认,1=热门")
    private Integer showInHost;
    /**
     * 是否置顶：0=默认,1=置顶
     */
    @ApiModelProperty(value = "是否置顶：0=默认,1=置顶")
    private Integer showInTop;


}
