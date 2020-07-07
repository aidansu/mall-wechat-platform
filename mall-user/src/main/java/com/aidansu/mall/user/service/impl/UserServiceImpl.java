package com.aidansu.mall.user.service.impl;

import com.aidansu.mall.core.constant.ApisConstant;
import com.aidansu.mall.core.error.ApisException;
import com.aidansu.mall.user.dao.UserMapper;
import com.aidansu.mall.user.dto.AdminUserLoginDTO;
import com.aidansu.mall.user.dto.WechatUserLoginDTO;
import com.aidansu.mall.user.entity.User;
import com.aidansu.mall.user.service.IUserService;
import com.aidansu.mall.user.wechat.entity.UserSession;
import com.aidansu.mall.user.wechat.service.MiniService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * 用户服务实现类
 *
 * @author aidan
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

//	@Resource
//	private UserMapper userMapper;

    @Resource
    private MiniService miniService;

    @Override
    public User findById(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findByMiniOpenid(String miniOpenid) {
        return baseMapper.selectByMiniOpenid(miniOpenid);
    }

    @Override
    public User findByUnionid(String unionid) {
        return baseMapper.selectByUnionid(unionid);
    }

    @Override
    public User loginByMini(WechatUserLoginDTO dto) {
        // 验证微信登录
        UserSession userSession = miniService.code2Session(dto.getCode());
        if (userSession == null) {
            throw new ApisException("获取不到该小程序用户信息");
        }

        LocalDateTime now = LocalDateTime.now();
        // 通过openid查找该用户是否存在
        User user = baseMapper.selectByMiniOpenid(userSession.getOpenid());
        // 如果不存在就新增用户，否则更新用户信息
        if (user == null) {
            user = User.builder()
                    .miniOpenid(userSession.getOpenid())
                    .sessionKey(userSession.getSessionKey())
                    .unionid(userSession.getUnionid())
                    .phone(dto.getPhone())
                    .nickName(dto.getNickname())
                    .gender(dto.getGender())
                    .language(dto.getLanguage())
                    .city(dto.getCity())
                    .province(dto.getProvince())
                    .county(dto.getCountry())
                    .avatar(dto.getAvatarUrl())
                    .lastLoginTime(now)
                    .createTime(now)
                    .updateTime(now)
                    .status(1)
                    .isDeleted(0)
                    .build();
            this.baseMapper.insertSelective(user);
        } else {
            if (StringUtils.isNotBlank(dto.getPhone())) {
                user.setPhone(dto.getPhone());
            }
            if (StringUtils.isNotBlank(userSession.getSessionKey())) {
                user.setSessionKey(userSession.getSessionKey());
            }
            if (StringUtils.isNotBlank(dto.getAvatarUrl())) {
                user.setAvatar(dto.getAvatarUrl());
            }
            if (StringUtils.isNotBlank(dto.getNickname())) {
                user.setNickName(dto.getNickname());
            }
            if (dto.getGender() != null && dto.getGender() > 0) {
                user.setGender(dto.getGender());
            }
            if (StringUtils.isNotBlank(dto.getLanguage())) {
                user.setLanguage(dto.getLanguage());
            }
            if (StringUtils.isNotBlank(dto.getCity())) {
                user.setCity(dto.getCity());
            }
            if (StringUtils.isNotBlank(dto.getProvince())) {
                user.setProvince(dto.getProvince());
            }
            if (StringUtils.isNotBlank(dto.getCountry())) {
                user.setCounty(dto.getCountry());
            }
            user.setUpdateTime(now);
            user.setLastLoginTime(now);
            this.baseMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public User loginByUsername(AdminUserLoginDTO dto) {
        User user = baseMapper.selectByUsernameAndTenantId(dto.getUsername(), dto.getTenantId());
        if (user == null) {
            //用户不存在（返回：用户名或密码错误 ）
            throw new ApisException(ApisConstant.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(dto.getPassword().getBytes(StandardCharsets.UTF_8)))) {
            //密码错误(返回：用户名或密码错误 )
            throw new ApisException(ApisConstant.USERNAME_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return user;
    }

    @Override
    public boolean deletedById(Long id) {
        return baseMapper.deleteByPrimaryKey(id) == 1;
    }
}
