package com.aidansu.mall.product.vo;

import com.aidansu.mall.product.entity.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 商品 视图实体类
 *
 * @author aidan
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProductVO对象", description = "商品")
public class ProductVO extends Product {

	private static final long serialVersionUID = 1L;

}
