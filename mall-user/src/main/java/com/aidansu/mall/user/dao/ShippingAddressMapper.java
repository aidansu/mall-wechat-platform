package com.aidansu.mall.user.dao;

import com.aidansu.mall.user.entity.ShippingAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  收货地址 Mapper 接口
 *
 * @author aidan
 * @since 2020-06-02
 */
public interface ShippingAddressMapper extends BaseMapper<ShippingAddress> {

	/**
	 * 自定义分页
	 *
	 * @param userId 用户ID
	 * @return List
	 */
	List<ShippingAddress> selectShippingAddressByUserId(@Param(value = "userId") Long userId);

}
