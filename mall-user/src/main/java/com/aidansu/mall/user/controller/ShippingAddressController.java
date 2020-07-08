package com.aidansu.mall.user.controller;

import com.aidansu.mall.core.api.R;
import com.aidansu.mall.core.error.ApisException;
import com.aidansu.mall.core.security.AuthUserDetails;
import com.aidansu.mall.core.security.utils.JwtTokenUtil;
import com.aidansu.mall.core.tool.utils.Func;
import com.aidansu.mall.user.entity.ShippingAddress;
import com.aidansu.mall.user.service.IShippingAddressService;
import com.aidansu.mall.user.vo.ShippingAddressVO;
import com.aidansu.mall.user.wrapper.ShippingAddressWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 收货地址 控制器
 *
 * @author aidan
 */
@RestController
@RequestMapping("/shipping-address")
@Api(value = "收货地址", tags = "收货地址接口")
public class ShippingAddressController {

    @Resource
    private IShippingAddressService shippingAddressService;

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入主键ID")
    public R<ShippingAddressVO> detail(@RequestParam Long id) {
        AuthUserDetails user = JwtTokenUtil.getUser();
        ShippingAddress detail = shippingAddressService.getById(id);
        if (detail == null) {
            throw new ApisException("没有找到 id=" + id + " 的收货地址详情");
        }
        if (!detail.getUserId().equals(user.getUserId())) {
            throw new ApisException("只能查看自己的收货地址详情");
        }
        return R.data(ShippingAddressWrapper.build().entityVO(detail));
    }


    /**
     * 收货地址列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "收货地址列表")
    public R<List<ShippingAddress>> list() {
        AuthUserDetails user = JwtTokenUtil.getUser();
        List<ShippingAddress> list = shippingAddressService.findShippingAddressListByUserId(user.getUserId());
        return R.data(list);
    }

    /**
     * 新增或修改
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入shippingAddress")
    public R submit(@Valid @RequestBody ShippingAddress shippingAddress) {
        AuthUserDetails user = JwtTokenUtil.getUser();
        shippingAddress.setUserId(user.getUserId());

        LocalDateTime now = LocalDateTime.now();
        shippingAddress.setCreateTime(now);
        shippingAddress.setUpdateTime(now);
        shippingAddress.setIsDeleted(0);
        return R.status(shippingAddressService.saveOrUpdate(shippingAddress));
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(shippingAddressService.removeByIds(Func.toLongList(ids)));
    }

    /**
     * 设置默认地址
     */
    @PostMapping("/default-address")
    @ApiOperation(value = "设置默认地址", notes = "传入id")
    public R defaultAddress(@ApiParam(value = "主键ID", required = true) @RequestParam Long id) {
        AuthUserDetails user = JwtTokenUtil.getUser();
        return R.status(shippingAddressService.setDefaultAddressById(user.getUserId(), id));
    }


}
