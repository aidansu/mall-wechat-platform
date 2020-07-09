package com.aidansu.mall.product.wrapper;

import com.aidansu.mall.core.mybatis.support.BaseEntityWrapper;
import org.springframework.beans.BeanUtils;
import com.aidansu.mall.product.entity.SelfAddress;
import com.aidansu.mall.product.vo.SelfAddressVO;

/**
 * 自提地址 包装类,返回视图层所需的字段
 *
 * @author aidan
 * @since 2019-07-09
 */
public class SelfAddressWrapper extends BaseEntityWrapper<SelfAddress, SelfAddressVO>  {

	public static SelfAddressWrapper build() {
		return new SelfAddressWrapper();
	}

	@Override
	public SelfAddressVO entityVO(SelfAddress selfAddress) {
		SelfAddressVO selfAddressVO = new SelfAddressVO();
		BeanUtils.copyProperties(selfAddress, selfAddressVO);

		return selfAddressVO;
	}

}
