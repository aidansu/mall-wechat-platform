package com.aidansu.mall.core.mybatis.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页工具
 *
 * @author aidan
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "查询条件")
public class Query {

	/**
	 * 当前页
	 */
	@ApiModelProperty(value = "当前页")
	private Integer current;

	/**
	 * 每页的数量
	 */
	@ApiModelProperty(value = "每页的数量")
	private Integer size;

//	/**
//	 * 排序方式
//	 */
//	@ApiModelProperty(value = "排序方式")
//	private List<OrderItem> orders;

	@ApiModelProperty(hidden = true)
	private String ascs;

	@ApiModelProperty(hidden = true)
	private String descs;

}
