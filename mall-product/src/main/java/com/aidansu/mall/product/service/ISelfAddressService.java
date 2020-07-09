package com.aidansu.mall.product.service;

import com.aidansu.mall.product.entity.SelfAddress;
import com.aidansu.mall.product.vo.SelfAddressVO;
import com.aidansu.mall.core.mybatis.base.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 自提地址 服务类
 *
 * @author aidan
 * @since 2019-07-09
 */
public interface ISelfAddressService extends BaseService<SelfAddress> {

	/**
	 * 自定义分页
	 *
	 * @param page 分页
	 * @param selfAddress vo
	 * @return 分页数据
	 */
	IPage<SelfAddressVO> selectSelfAddressPage(IPage<SelfAddressVO> page, SelfAddressVO selfAddress);

}
