package com.aidansu.mall.core.security.utils;

import com.aidansu.mall.core.constant.TokenConstant;
import com.aidansu.mall.core.security.TokenInfo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.*;

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
	public Claims getClaimsFromToken(String token) {
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
	public Date getExpirationDateFromToken(String token) {
		return getClaimsFromToken(token)
				.getExpiration();
	}

	/**
	 * 判断token是否过期
	 *
	 * @param token token
	 * @return 已过期返回true，未过期返回false
	 */
	private Boolean isTokenExpired(String token) {
		Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * 计算token的过期时间
	 *
	 * @return 过期时间
	 */
	public Date getExpirationTime() {
		return new Date(System.currentTimeMillis() + TokenConstant.EXPIRES_IN_ACCESS * 1000);
	}

	/**
	 * 为指定用户生成token
	 *
	 * @param claims 用户信息
	 * @return token
	 */
	public String generateToken(Map<String, Object> claims) {
		Date createdTime = new Date();
		Date expirationTime = this.getExpirationTime();


		byte[] keyBytes = TokenConstant.SIGN_KEY.getBytes();
		SecretKey key = Keys.hmacShaKeyFor(keyBytes);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(createdTime)
				.setExpiration(expirationTime)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
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


}
