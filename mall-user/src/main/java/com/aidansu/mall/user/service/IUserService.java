package com.aidansu.mall.user.service;

import com.aidansu.mall.user.dto.AdminUserLoginDTO;
import com.aidansu.mall.user.dto.WechatUserLoginDTO;
import com.aidansu.mall.user.entity.ShippingAddress;
import com.aidansu.mall.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户服务类
 *
 * @author aidansu
 */
public interface IUserService extends IService<User> {

    /**
     * 通过用户id查找用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User findById(Long id);

    /**
     * 通过用户微信小程序Openid查找用户信息
     *
     * @param miniOpenid 用户微信小程序Openid
     * @return 用户信息
     */
    User findByMiniOpenid(String miniOpenid);

    /**
     * 通过用户微信unionid查找用户信息
     *
     * @param unionid 用户微信unionid
     * @return 用户信息
     */
    User findByUnionid(String unionid);

    /**
     * 微信用户登录
     *
     * @param dto 用户登录信息
     * @return 用户信息
     */
    User loginByMini(WechatUserLoginDTO dto);

    /**
     * 管理员用户登录
     *
     * @param dto 用户登录信息
     * @return 用户信息
     */
    User loginByUsername(AdminUserLoginDTO dto);

    /**
     * 通过用户id删除用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    boolean deletedById(Long id);

}
