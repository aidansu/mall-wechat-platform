package com.aidansu.mall.product.controller;

import com.aidansu.mall.core.api.R;
import com.aidansu.mall.core.mybatis.support.Condition;
import com.aidansu.mall.core.mybatis.support.Query;

import com.aidansu.mall.core.tool.utils.Func;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.aidansu.mall.product.entity.SelfAddress;
import com.aidansu.mall.product.vo.SelfAddressVO;
import com.aidansu.mall.product.wrapper.SelfAddressWrapper;
import com.aidansu.mall.product.service.ISelfAddressService;

/**
 * 自提地址 控制器
 *
 * @author aidan
 * @since 2019-07-09
 */
@RestController
@RequestMapping("/self-address")
@Api(value = "自提地址", tags = "自提地址接口")
public class SelfAddressController {

    @Resource
	private ISelfAddressService selfAddressService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入selfAddress")
	public R<SelfAddressVO> detail(SelfAddress selfAddress) {
		SelfAddress detail = selfAddressService.getOne(Condition.getQueryWrapper(selfAddress));
		return R.data(SelfAddressWrapper.build().entityVO(detail));
	}

	/**
	 * 自定义分页 自提地址
	 */
	@GetMapping
	@ApiOperation(value = "分页", notes = "传入selfAddress")
	public R<IPage<SelfAddressVO>> page(SelfAddressVO selfAddress, Query query) {
		IPage<SelfAddressVO> pages = selfAddressService.selectSelfAddressPage(Condition.getPage(query), selfAddress);
		return R.data(pages);
	}

	/**
	 * 新增 自提地址
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入selfAddress")
	public R<Boolean> save(@Valid @RequestBody SelfAddress selfAddress) {
		return R.status(selfAddressService.save(selfAddress));
	}

	/**
	 * 修改 自提地址
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入selfAddress")
	public R<Boolean> update(@Valid @RequestBody SelfAddress selfAddress) {
		return R.status(selfAddressService.updateById(selfAddress));
	}

	/**
	 * 新增或修改 自提地址
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入selfAddress")
	public R<Boolean> submit(@Valid @RequestBody SelfAddress selfAddress) {
		return R.status(selfAddressService.saveOrUpdate(selfAddress));
	}


	/**
	 * 删除 自提地址
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R<Boolean> remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(selfAddressService.removeByIds(Func.toLongList(ids)));
	}


}
