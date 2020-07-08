package com.aidansu.mall.product.service.impl;

import com.aidansu.mall.core.mybatis.base.BaseServiceImpl;
import com.aidansu.mall.core.tool.node.ForestNodeMerger;
import com.aidansu.mall.product.dao.CategoryMapper;
import com.aidansu.mall.product.entity.Category;
import com.aidansu.mall.product.service.ICategoryService;
import com.aidansu.mall.product.vo.CategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  商品分类 服务实现类
 *
 * @author aidan
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements ICategoryService {

	@Override
	public List<CategoryVO> tree(String tenantId) {
		return ForestNodeMerger.merge(baseMapper.tree(tenantId));
	}


}
