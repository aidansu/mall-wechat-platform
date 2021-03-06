package com.aidansu.mall.user.dao;

import com.aidansu.mall.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户 Mapper 接口
 *
 * @author aidansu
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByPrimaryKey(Long id);

    User selectByMiniOpenid(String miniOpenid);

    User selectByUnionid(String unionid);

    int deleteByPrimaryKey(Long id);

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User record);

    User selectByUsernameAndTenantId(String username, String tenantId);

}