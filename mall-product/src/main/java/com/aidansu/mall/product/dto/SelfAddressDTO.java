package com.aidansu.mall.product.dto;

import com.aidansu.mall.product.entity.SelfAddress;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自提地址 数据传输对象实体类
 *
 * @author aidan
 * @since 2019-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SelfAddressDTO extends SelfAddress {

	private static final long serialVersionUID = 1L;

}
