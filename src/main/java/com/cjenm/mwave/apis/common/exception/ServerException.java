package com.cjenm.mwave.apis.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;
    private final Object[] messageArgs;
    private final Throwable ex;

    public ServerException(String code) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.messageArgs = null;
        this.ex = null;
    }

    public ServerException(String code, Throwable ex) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.messageArgs = null;
        this.ex = ex;
    }

    public ServerException(String code, Object[] messageArgs) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.messageArgs = messageArgs;
        this.ex = null;
    }

    public ServerException(String code, Object[] messageArgs, Throwable ex) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.messageArgs = messageArgs;
        this.ex = ex;
    }
}
