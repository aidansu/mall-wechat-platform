package com.aidansu.mall.core.security.auth;

import com.aidansu.mall.core.api.ResultCode;
import com.aidansu.mall.core.constant.TokenConstant;
import com.aidansu.mall.core.security.exception.SecureException;
import com.aidansu.mall.core.utils.WebUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
			"@annotation(com.aidansu.mall.core.security.auth.PreAuth) || " +
					"@within(com.aidansu.mall.core.security.auth.PreAuth)"
	)
	public Object preAuth(ProceedingJoinPoint point) throws Throwable {
		if (handleAuth(point)) {
			return point.proceed();
		}
		throw new SecureException(ResultCode.UN_AUTHORIZED);
	}

	/**
	 * 处理权限
	 *
	 * @param point 切点
	 */
	private boolean handleAuth(ProceedingJoinPoint point) {
		try {
			HttpServletRequest request = WebUtil.getRequest();
			if(request == null){
				return false;
			}

			List<String> authorities = new ArrayList<>();
			Object obj  = request.getAttribute(TokenConstant.AUTHORITIES);
			if (obj  instanceof ArrayList<?>) {
				for (Object o : (List<?>) obj ) {
					authorities.add((String) o);
				}
			}

			MethodSignature signature = (MethodSignature) point.getSignature();
			Method method = signature.getMethod();
			PreAuth annotation = method.getAnnotation(PreAuth.class);

			String value = annotation.value();

			for(String role: authorities){
				if(Objects.equals(role, value)){
					return true;
				}
			}
		} catch (Throwable throwable) {
			throw new SecureException(ResultCode.UN_AUTHORIZED,throwable);
		}
		return false;

	}




}
