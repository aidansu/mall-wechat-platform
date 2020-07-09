package com.aidansu.mall.product.service.impl;

import com.aidansu.mall.product.entity.SelfAddress;
import com.aidansu.mall.product.vo.SelfAddressVO;
import com.aidansu.mall.product.dao.SelfAddressMapper;
import com.aidansu.mall.product.service.ISelfAddressService;
import com.aidansu.mall.core.mybatis.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 自提地址 服务实现类
 *
 * @author aidan
 * @since 2019-07-09
 */
@Service
public class SelfAddressServiceImpl extends BaseServiceImpl<SelfAddressMapper, SelfAddress> implements ISelfAddressService {

	@Override
	public IPage<SelfAddressVO> selectSelfAddressPage(IPage<SelfAddressVO> page, SelfAddressVO selfAddress) {
		return page.setRecords(baseMapper.selectSelfAddressPage(page, selfAddress));
	}

}
