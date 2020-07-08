package com.aidansu.mall.core.tool.node;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;

/**
 * 节点
 *
 * @author aidan
 */
public interface INode {

	/**
	 * 主键
	 *
	 * @return Integer
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	Long getId();

	/**
	 * 父主键
	 *
	 * @return Integer
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	Long getParentId();

	/**
	 * 子孙节点
	 *
	 * @return List
	 */
	List<INode> getChildren();

}
