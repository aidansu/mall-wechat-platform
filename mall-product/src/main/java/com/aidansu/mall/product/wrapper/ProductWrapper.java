package com.aidansu.mall.product.wrapper;

import com.aidansu.mall.core.mybatis.support.BaseEntityWrapper;
import org.springframework.beans.BeanUtils;
import com.aidansu.mall.product.entity.Product;
import com.aidansu.mall.product.vo.ProductVO;

/**
 * 商品 包装类,返回视图层所需的字段
 *
 * @author aidan
 * @since 2020-07-10
 */
public class ProductWrapper extends BaseEntityWrapper<Product, ProductVO>  {

	public static ProductWrapper build() {
		return new ProductWrapper();
	}

	@Override
	public ProductVO entityVO(Product product) {
		ProductVO productVO = new ProductVO();
		BeanUtils.copyProperties(product, productVO);

		return productVO;
	}

}
