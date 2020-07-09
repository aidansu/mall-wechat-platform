package com.aidansu.mall.product.vo;

import com.aidansu.mall.product.entity.SelfAddress;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 自提地址 视图实体类
 *
 * @author aidan
 * @since 2019-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SelfAddressVO对象", description = "自提地址")
public class SelfAddressVO extends SelfAddress {

	private static final long serialVersionUID = 1L;

}
