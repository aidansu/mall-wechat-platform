package com.aidansu.mall.product.dao;

import com.aidansu.mall.product.entity.SelfAddress;
import com.aidansu.mall.product.vo.SelfAddressVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 自提地址 Mapper 接口
 *
 * @author aidan
 * @since 2019-07-09
 */
public interface SelfAddressMapper extends BaseMapper<SelfAddress> {

	/**
	 * 自定义分页
	 *
	 * @param page 分页
	 * @param selfAddress vo
	 * @return 分页List
	 */
	List<SelfAddressVO> selectSelfAddressPage(IPage page, SelfAddressVO selfAddress);

}
