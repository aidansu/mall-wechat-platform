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
import com.aidansu.mall.product.entity.Product;
import com.aidansu.mall.product.vo.ProductVO;
import com.aidansu.mall.product.wrapper.ProductWrapper;
import com.aidansu.mall.product.service.IProductService;

/**
 * 商品 控制器
 *
 * @author aidan
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/products")
@Api(value = "商品", tags = "商品接口")
public class ProductController {

    @Resource
	private IProductService productService;

	/**
	 * 详情
	 */
	@GetMapping("/{productId}")
	@ApiOperation(value = "详情", notes = "传入商品ID：productId")
	public R<ProductVO> detail(@PathVariable Long productId) {
		Product detail = productService.findById(productId);
		return R.data(ProductWrapper.build().entityVO(detail));
	}

	/**
	 * 自定义分页 商品
	 */
	@GetMapping
	@ApiOperation(value = "分页", notes = "传入product")
	public R<IPage<ProductVO>> page(ProductVO product, Query query) {
		IPage<ProductVO> pages = productService.selectProductPage(Condition.getPage(query), product);
		return R.data(pages);
	}

	/**
	 * 新增或修改 商品
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入product")
	public R<Boolean> submit(@Valid @RequestBody Product product) {
		return R.status(productService.saveOrUpdate(product));
	}

	/**
	 * 删除 商品
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R<Boolean> remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(productService.removeByIds(Func.toLongList(ids)));
	}


}
