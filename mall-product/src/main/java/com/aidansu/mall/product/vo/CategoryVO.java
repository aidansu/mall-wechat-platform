package com.aidansu.mall.product.vo;

import com.aidansu.mall.core.tool.node.INode;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *  商品分类 视图实体类
 *
 * @author aidan
 */
@Data
@ApiModel(value = "CategoryVO对象", description = "CategoryVO对象")
public class CategoryVO implements INode {

	private static final long serialVersionUID = 1L;
	/**
	 * 类别Id
	 */
	@ApiModelProperty(value = "类别Id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 父类别id当id=0时说明是根节点,一级类别
	 */
	@ApiModelProperty(value = "父类别id当id=0时说明是根节点,一级类别")
	private Long parentId;
	/**
	 * 类别名称
	 */
	@ApiModelProperty(value = "类别名称")
	private String name;
	/**
	 * 排序编号,同类展示顺序,数值相等则自然排序
	 */
	@ApiModelProperty(value = "排序编号,同类展示顺序,数值相等则自然排序")
	private Integer sort;
	/**
	 * 子孙节点
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<INode> children;

	@Override
	public List<INode> getChildren() {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}
		return this.children;
	}

}
