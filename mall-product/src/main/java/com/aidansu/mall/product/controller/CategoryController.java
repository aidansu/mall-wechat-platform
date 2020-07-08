package com.aidansu.mall.product.controller;

import com.aidansu.mall.core.mybatis.support.Condition;
import com.aidansu.mall.core.tool.utils.Func;
import com.aidansu.mall.product.entity.Category;
import com.aidansu.mall.product.service.ICategoryService;
import com.aidansu.mall.product.vo.CategoryVO;
import com.aidansu.mall.product.wrapper.CategoryWrapper;
import com.aidansu.mall.core.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 *  商品类别 控制器
 *
 * @author aidan
 */
@RestController
@RequestMapping("/category")
@Api(value = "商品类别", tags = "商品类别接口")
public class CategoryController {

	@Resource
	private ICategoryService categoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入category")
	public R<CategoryVO> detail(Category category) {
		Category detail = categoryService.getOne(Condition.getQueryWrapper(category));
		return R.data(CategoryWrapper.build().entityVO(detail));
	}


	/**
	 * 商品类别树形列表
	 */
	@GetMapping
	@ApiOperation(value = "商品类别树形列表", notes = "传入租户ID：tenantId")
	public R<List<CategoryVO>> treeList(@RequestParam("tenantId") String tenantId) {
		List<CategoryVO> list = categoryService.tree(tenantId);
		return R.data(list);
	}

	/**
	 * 新增或修改 
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入category")
	public R submit(@Valid @RequestBody Category category) {
		return R.status(categoryService.saveOrUpdate(category));
	}


	/**
	 * 删除 
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(categoryService.removeByIds(Func.toLongList(ids)));
	}


}
