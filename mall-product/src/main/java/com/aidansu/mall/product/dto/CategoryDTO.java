package com.aidansu.mall.product.dto;

import com.aidansu.mall.product.entity.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  商品类别 数据传输对象实体类
 *
 * @author aidan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends Category {

	private static final long serialVersionUID = 1L;

}
