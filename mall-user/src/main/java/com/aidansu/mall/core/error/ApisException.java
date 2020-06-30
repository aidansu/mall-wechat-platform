package com.aidansu.mall.core.error;

/**
 * 错误信息抛出异常类
 *
 * @author aidan
 */
public class ApisException extends RuntimeException {

    public ApisException(String message) {
        super(message);
    }

    public ApisException(Throwable cause) {
        super(cause);
    }

    public ApisException(String message, Throwable cause) {
        super(message, cause);
    }

}