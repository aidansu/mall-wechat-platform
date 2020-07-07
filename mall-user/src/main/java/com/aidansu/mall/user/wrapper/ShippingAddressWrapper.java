package com.aidansu.mall.user.wrapper;

import com.aidansu.mall.core.mybatis.support.BaseEntityWrapper;
import com.aidansu.mall.user.entity.ShippingAddress;
import com.aidansu.mall.user.vo.ShippingAddressVO;
import org.springframework.beans.BeanUtils;

/**
 * 收货地址 包装类,返回视图层所需的字段
 *
 * @author aidan
 */
public class ShippingAddressWrapper extends BaseEntityWrapper<ShippingAddress, ShippingAddressVO> {

    public static ShippingAddressWrapper build() {
        return new ShippingAddressWrapper();
    }

    @Override
    public ShippingAddressVO entityVO(ShippingAddress shippingAddress) {
        ShippingAddressVO shippingAddressVO = new ShippingAddressVO();
        BeanUtils.copyProperties(shippingAddress, shippingAddressVO);
        return shippingAddressVO;
    }

}
