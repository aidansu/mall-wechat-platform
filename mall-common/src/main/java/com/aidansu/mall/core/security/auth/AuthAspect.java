package com.aidansu.mall.core.security.auth;

import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.constant.TokenConstant;
import com.aidansu.mall.core.security.exception.SecureException;
import com.aidansu.mall.core.security.utils.JwtUtil;
import com.aidansu.mall.core.utils.WebUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 鉴权
 *
 * @author aidan
 */
@Aspect
@Component
public class AuthAspect {

	/**
	 * 切 方法 和 类上的 @CheckLogin 注解
	 *
	 * @param point 切点
	 * @return Object
	 * @throws Throwable 没有权限的异常
	 */
	@Around(
			"@annotation(com.aidansu.mall.core.security.auth.CheckLogin) || " +
					"@within(com.aidansu.mall.core.security.auth.CheckLogin)"
	)
	public Object CheckLogin(ProceedingJoinPoint point) throws Throwable {
		if (checkToken()) {
			return point.proceed();
		}
		throw new SecureException(ResultCode.UN_AUTHORIZED);
	}


	private boolean checkToken() {
		try {
			// 1. 从header里面获取token
			HttpServletRequest request = WebUtil.getRequest();
			if(request == null){
				return false;
			}
			String token = JwtUtil.getToken(request);
			if(StringUtils.isBlank(token)){
				return false;
			}

			// 2. 校验token是否合法&是否过期；如果不合法或已过期直接抛异常；如果合法放行
			Boolean isValid = JwtUtil.validateToken(token);
			if (!isValid) {
				throw new SecureException(ResultCode.TOKEN_ILLEGAL);
			}

			// 3. 如果校验成功，那么就将用户的信息设置到request的attribute里面
			Claims claims = JwtUtil.getClaimsFromToken(token);
			request.setAttribute(TokenConstant.TENANT_ID, claims.get(TokenConstant.TENANT_ID));
			request.setAttribute(TokenConstant.USER_ID, claims.get(TokenConstant.USER_ID));
			request.setAttribute(TokenConstant.NICK_NAME, claims.get(TokenConstant.NICK_NAME));
			request.setAttribute(TokenConstant.AUTHORITIES, claims.get(TokenConstant.AUTHORITIES));

			return true;
		} catch (Throwable throwable) {
			throw new SecureException(ResultCode.TOKEN_ILLEGAL);
		}
	}

}
