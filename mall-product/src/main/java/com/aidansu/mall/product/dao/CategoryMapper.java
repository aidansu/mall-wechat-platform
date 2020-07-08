package com.aidansu.mall.product.dao;

import com.aidansu.mall.product.entity.Category;
import com.aidansu.mall.product.vo.CategoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  商品类别 Mapper 接口
 *
 * @author aidan
 */
public interface CategoryMapper extends BaseMapper<Category> {

	/**
	 * 树形结构
	 *
	 * @param tenantId 租户ID
	 * @return List
	 */
	List<CategoryVO> tree(@Param(value = "tenantId") String tenantId);

}
