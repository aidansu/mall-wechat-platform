package com.aidansu.mall.user.vo;

import com.aidansu.mall.user.entity.ShippingAddress;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收货地址 视图实体类
 *
 * @author aidan
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ShippingAddressVO对象", description = "ShippingAddressVO对象")
public class ShippingAddressVO extends ShippingAddress {

    private static final long serialVersionUID = 1L;

}
