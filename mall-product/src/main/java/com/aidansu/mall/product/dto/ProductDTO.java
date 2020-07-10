package com.aidansu.mall.product.dto;

import com.aidansu.mall.product.entity.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品 数据传输对象实体类
 *
 * @author aidan
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends Product {

	private static final long serialVersionUID = 1L;

}
