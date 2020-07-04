package com.aidansu.mall.user.service;

import com.aidansu.mall.user.entity.ShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  收货地址 服务类
 *
 * @author aidan
 */
public interface IShippingAddressService extends IService<ShippingAddress> {

	/**
	 * 自定义分页
	 *
	 * @param userId 用户id
	 * @return 分页数据
	 */
	List<ShippingAddress> findShippingAddressListByUserId(Long userId);

	/**
	 * 设置默认地址
	 *
	 * @param userId 用户ID
	 * @param id 地址ID
	 * @return boolean
	 */
	boolean setDefaultAddressById(Long userId, Long id);

}
