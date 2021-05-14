package com.cjenm.mwave.apis.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BizException extends RuntimeException {
    private HttpStatus httpStatus;
    private String code;
    private Object[] messageArgs;

    public BizException(HttpStatus httpStatus, String code) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.messageArgs = null;
    }

    public BizException(HttpStatus httpStatus, String code, Object[] messageArgs) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.messageArgs = messageArgs;
    }
}
