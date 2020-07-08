package com.aidansu.mall.product.wrapper;

import com.aidansu.mall.core.mybatis.support.BaseEntityWrapper;
import com.aidansu.mall.product.entity.Category;
import com.aidansu.mall.product.vo.CategoryVO;
import org.springframework.beans.BeanUtils;

/**
 *  商品分类 包装类,返回视图层所需的字段
 *
 * @author aidan
 */
public class CategoryWrapper extends BaseEntityWrapper<Category, CategoryVO> {

	public static CategoryWrapper build() {
		return new CategoryWrapper();
	}

	@Override
	public CategoryVO entityVO(Category category) {
		CategoryVO categoryVO = new CategoryVO();
		BeanUtils.copyProperties(category, categoryVO);

		return categoryVO;
	}

}
