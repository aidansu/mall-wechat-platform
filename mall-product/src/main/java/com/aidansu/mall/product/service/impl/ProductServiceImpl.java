package com.aidansu.mall.product.service.impl;

import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.error.ApisException;
import com.aidansu.mall.product.entity.Product;
import com.aidansu.mall.product.vo.ProductVO;
import com.aidansu.mall.product.dao.ProductMapper;
import com.aidansu.mall.product.service.IProductService;
import com.aidansu.mall.core.mybatis.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品 服务实现类
 *
 * @author aidan
 * @since 2020-07-10
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, Product> implements IProductService {

	@Override
	public IPage<ProductVO> selectProductPage(IPage<ProductVO> page, ProductVO product) {
		return page.setRecords(baseMapper.selectProductPage(page, product));
	}

	@Override
	public Product findById(Long id) {
		Product product = baseMapper.selectById(id);
		// 判断商品是否已经下架
		if(product == null || product.getStatus() == 0){
			throw new ApisException(ResultCode.PRODUCT_OFF_SALE_OR_DELETE);
		}
		// 敏感数据处理
		product.setStock(product.getStock() > 100 ? 100 : product.getStock());
		return product;
	}

}
