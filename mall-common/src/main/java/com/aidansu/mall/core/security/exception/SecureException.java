package com.aidansu.mall.core.security.exception;

import com.aidansu.mall.core.api.ResultCode;
import lombok.Getter;

/**
 * Secure异常
 *
 * @author aidan
 */
@Getter
public class SecureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ResultCode resultCode;

	public SecureException(String message) {
		super(message);
		this.resultCode = ResultCode.UN_AUTHORIZED;
	}

	public SecureException(ResultCode resultCode) {
		super(resultCode.getMessage());
		this.resultCode = resultCode;
	}

	public SecureException(ResultCode resultCode, Throwable cause) {
		super(cause);
		this.resultCode = resultCode;
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
