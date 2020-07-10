package com.aidansu.mall.core.error;

import com.aidansu.mall.core.api.ResultCode;
import lombok.Getter;

/**
 * 错误信息抛出异常类
 *
 * @author aidan
 */
@Getter
public class ApisException extends RuntimeException {

    private final ResultCode resultCode;

    public ApisException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public ApisException(Throwable cause) {
        super(cause);
        this.resultCode = ResultCode.FAILURE;
    }

    public ApisException(String message, Throwable cause) {
        super(message, cause);
        this.resultCode = ResultCode.FAILURE;
    }

    public ApisException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

}