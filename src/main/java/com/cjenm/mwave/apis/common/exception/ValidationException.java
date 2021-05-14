package com.cjenm.mwave.apis.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;
    private final Object[] messageArgs;

    public ValidationException(String code, Object[] messageArgs) {
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.code = code;
        this.messageArgs = messageArgs;
    }

    public ValidationException(String code) {
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.code = code;
        this.messageArgs = null;
    }
}
