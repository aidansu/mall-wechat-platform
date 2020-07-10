package com.aidansu.mall.product.service;

import com.aidansu.mall.product.entity.Product;
import com.aidansu.mall.product.vo.ProductVO;
import com.aidansu.mall.core.mybatis.base.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品 服务类
 *
 * @author aidan
 * @since 2020-07-10
 */
public interface IProductService extends BaseService<Product> {

	/**
	 * 自定义分页
	 *
	 * @param page 分页
	 * @param product vo
	 * @return 分页数据
	 */
	IPage<ProductVO> selectProductPage(IPage<ProductVO> page, ProductVO product);

	/**
	 * 通过ID获取商品详情
	 *
	 * @param id 主键ID
	 * @return Product
	 */
	Product findById(Long id);

}
