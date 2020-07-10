package com.aidansu.mall.product.dao;

import com.aidansu.mall.product.entity.Product;
import com.aidansu.mall.product.vo.ProductVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 商品 Mapper 接口
 *
 * @author aidan
 * @since 2020-07-10
 */
public interface ProductMapper extends BaseMapper<Product> {

	/**
	 * 自定义分页
	 *
	 * @param page 分页
	 * @param product vo
	 * @return 分页List
	 */
	List<ProductVO> selectProductPage(IPage page, ProductVO product);



}
