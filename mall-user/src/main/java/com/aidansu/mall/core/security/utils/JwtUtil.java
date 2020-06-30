package com.aidansu.mall.core.security.utils;

import com.aidansu.mall.core.constant.TokenConstant;
import com.aidansu.mall.core.security.JwtUser;
import com.aidansu.mall.core.security.TokenInfo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @author aidan
 */
@Slf4j
public class JwtUtil {

	/**
	 * 从token中获取claim
	 *
	 * @param token token
	 * @return claim
	 */
	public static Claims getClaimsFromToken(String token) {
		try {
			return Jwts.parser()
					.setSigningKey(TokenConstant.SIGN_KEY.getBytes())
					.parseClaimsJws(token)
					.getBody();
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
			log.error("token解析错误", e);
			throw new IllegalArgumentException("Token invalided.");
		}
	}

	/**
	 * 获取token的过期时间
	 *
	 * @param token token
	 * @return 过期时间
	 */
	public static Date getExpirationDateFromToken(String token) {
		return getClaimsFromToken(token)
				.getExpiration();
	}

	/**
	 * 判断token是否过期
	 *
	 * @param token token
	 * @return 已过期返回true，未过期返回false
	 */
	private static Boolean isTokenExpired(String token) {
		Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * 判断token是否非法
	 *
	 * @param token token
	 * @return 未过期返回true，否则返回false
	 */
	public static Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}

	/**
	 * 计算token的过期时间
	 *
	 * @return 过期时间
	 */
	public static Date getExpirationTime() {
		return new Date(System.currentTimeMillis() + TokenConstant.EXPIRES_IN_ACCESS * 1000);
	}

	/**
	 * 创建令牌
	 *
	 * @param claims      claims
	 * @param tokenType tokenType
	 * @return jwt
	 */
	public static TokenInfo createJWT(Map<String, Object> claims, String tokenType) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		//生成签名密钥
		byte[] keyBytes = TokenConstant.SIGN_KEY.getBytes();
		SecretKey signingKey = Keys.hmacShaKeyFor(keyBytes);

		JwtBuilder builder = Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setClaims(claims)
				.setIssuedAt(now)
				// 支持的算法详见：https://github.com/jwtk/jjwt#features
				.signWith(signingKey, signatureAlgorithm);

		//添加Token过期时间
		long expireMillis;
		if (tokenType.equals(TokenConstant.ACCESS_TOKEN)) {
			expireMillis = TokenConstant.EXPIRES_IN_ACCESS * 1000;
		} else if (tokenType.equals(TokenConstant.REFRESH_TOKEN)) {
			expireMillis = TokenConstant.EXPIRES_IN_REFRESH * 1000;
		} else {
			expireMillis = TokenConstant.EXPIRES_IN_ACCESS * 1000;
		}
		long expMillis = nowMillis + expireMillis;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp).setNotBefore(now);

		// 组装Token信息
		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setToken(builder.compact());
		tokenInfo.setExpire((int) expireMillis / 1000);
		tokenInfo.setScope("all");
		return tokenInfo;
	}

	/**
	 * 获取用户信息
	 *
	 * @return jwtUser
	 */
	public static JwtUser getUser(HttpServletRequest request) {
		Claims claims = getClaims(request);
		if (claims == null) {
			return null;
		}
		Long userId = Long.valueOf(String.valueOf(claims.get(TokenConstant.USER_ID)));
		String tenantId = String.valueOf(claims.get(TokenConstant.TENANT_ID));
		String nickName = String.valueOf(claims.get(TokenConstant.NICK_NAME));

		List<String> authorities = new ArrayList<>();
		Object obj = claims.get(TokenConstant.AUTHORITIES);
		if (obj instanceof ArrayList<?>) {
			for (Object o : (List<?>) obj) {
				authorities.add((String) o);
			}
		}

		return JwtUser.builder()
				.tenantId(tenantId)
				.userId(userId)
				.nickName(nickName)
				.authorities(authorities)
				.build();
	}
	/**
	 * 获取用户信息
	 *
	 * @return jwtUser
	 */
	public static JwtUser getUser() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			return getUser(request);
		}
		return null;
	}

	/**
	 * 获取Claims
	 *
	 * @param request request
	 * @return Claims
	 */
	public static Claims getClaims(HttpServletRequest request) {
		String token = getToken(request);
		if(StringUtils.isNotBlank(token)){
			return JwtUtil.getClaimsFromToken(token);
		}
		return null;
	}

	/**
	 * 获取Claims
	 *
	 * @param request request
	 * @return Claims
	 */
	public static String getToken(HttpServletRequest request) {
		String auth = request.getHeader(TokenConstant.HEADER);
		if ((auth != null) && (auth.length() > TokenConstant.AUTH_LENGTH)) {
			String headStr = auth.substring(0, 6).toLowerCase();
			if (headStr.compareTo(TokenConstant.BEARER) == 0) {
				auth = auth.substring(TokenConstant.AUTH_LENGTH);
				return auth;
			}
		}
		return null;
	}

}
