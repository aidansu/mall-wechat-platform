package com.aidansu.mall.user.service.impl;

import com.aidansu.mall.core.error.ApisException;
import com.aidansu.mall.user.dao.ShippingAddressMapper;
import com.aidansu.mall.user.entity.ShippingAddress;
import com.aidansu.mall.user.service.IShippingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author aidan
 * @since 2020-06-02
 */
@Service
public class ShippingAddressServiceImpl extends ServiceImpl<ShippingAddressMapper, ShippingAddress> implements IShippingAddressService {

    @Override
    public List<ShippingAddress> findShippingAddressListByUserId(Long userId) {
        return baseMapper.selectShippingAddressByUserId(userId);
    }

    @Override
    public boolean setDefaultAddressById(Long userId, Long id) {
        // 该地址Id是否存在
        boolean result = false;

        // 查找该用户的所有收货地址
        List<ShippingAddress> addressList = baseMapper.selectShippingAddressByUserId(userId);

        // 将原来有默认收货地址更改为非默认收货地址,设置当前收货地址为默认收货地址
        for (ShippingAddress address : addressList) {
            if (address.getDefaultStatus() == 1) {
                if (address.getId().equals(id)) {
                    break;
                } else {
                    address.setDefaultStatus(0);
                    baseMapper.updateById(address);
                }
            }
        }

        for (ShippingAddress address : addressList) {
            if (address.getId().equals(id)) {
                result = true;
                address.setDefaultStatus(1);
                baseMapper.updateById(address);
                break;
            }
        }

        // 如果不存在该地址ID，返回错误信息
        if (!result) {
            throw new ApisException("没有找到该地址信息");
        }

        return true;
    }
}
