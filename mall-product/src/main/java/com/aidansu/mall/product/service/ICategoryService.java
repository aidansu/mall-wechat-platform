package com.aidansu.mall.product.service;

import com.aidansu.mall.core.mybatis.base.BaseService;
import com.aidansu.mall.product.entity.Category;
import com.aidansu.mall.product.vo.CategoryVO;

import java.util.List;

/**
 *  商品分类 服务类
 *
 * @author aidan
 */
public interface ICategoryService extends BaseService<Category> {

	/**
	 * 树形结构
	 *
	 * @param tenantId 租户ID
	 * @return List
	 */
	List<CategoryVO> tree(String tenantId);

}
