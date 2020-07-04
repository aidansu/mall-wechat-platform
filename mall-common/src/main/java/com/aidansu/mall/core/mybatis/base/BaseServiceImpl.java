package com.aidansu.mall.core.mybatis.base;

import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.security.AuthUserDetails;
import com.aidansu.mall.core.security.exception.SecureException;
import com.aidansu.mall.core.security.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 业务封装基础类
 *
 * @param <M> mapper
 * @param <T> model
 * @author Chill
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
	private Class<T> modelClass;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		Type type = this.getClass().getGenericSuperclass();
		this.modelClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[1];
	}

	@Override
	public boolean save(T entity) {
		AuthUserDetails user = JwtTokenUtil.getUser();
		if(user == null){
			throw new SecureException(ResultCode.UN_AUTHORIZED);
		}
		LocalDateTime now = LocalDateTime.now();
		entity.setCreateUser(user.getUserId());
		entity.setCreateTime(now);
		entity.setUpdateUser(user.getUserId());
		entity.setUpdateTime(now);
		entity.setStatus(1);
		entity.setIsDeleted(0);
		return super.save(entity);
	}

	@Override
	public boolean updateById(T entity) {
		AuthUserDetails user = JwtTokenUtil.getUser();
		if(user == null){
			throw new SecureException(ResultCode.UN_AUTHORIZED);
		}
		entity.setUpdateUser(user.getUserId());
		entity.setUpdateTime(LocalDateTime.now());
		return super.updateById(entity);
	}

	@Override
	public boolean deleteLogic(@NotEmpty List<Long> ids) {
		AuthUserDetails user = JwtTokenUtil.getUser();
		if(user == null){
			throw new SecureException(ResultCode.UN_AUTHORIZED);
		}
		T entity =  BeanUtils.instantiateClass(this.modelClass);
		entity.setUpdateUser(user.getUserId());
		entity.setUpdateTime(LocalDateTime.now());
		return this.update(entity, Wrappers.<T>update().lambda().in(BaseEntity::getId, ids)) && super.removeByIds(ids);
	}

}
