package com.cjenm.mwave.apis.common.model;

import com.cjenm.mwave.apis.common.constants.CommonConts;
import com.cjenm.mwave.apis.common.utils.MessageUtil;
import lombok.Getter;

@Getter
public class Result<T>{
    private String resultCd;
    private String resultMsg;
    private T result;

    public Result() {
        this.resultCd = CommonConts.RESULT_SUCCESS_CODE;
        this.resultMsg = MessageUtil.getMessage(CommonConts.MESSAGE_BASE_NAME.concat(this.resultCd));
        this.result = null;
    }

    public Result(T data) {
        this.resultCd = CommonConts.RESULT_SUCCESS_CODE;
        this.resultMsg = MessageUtil.getMessage(CommonConts.MESSAGE_BASE_NAME.concat(this.resultCd));
        this.result = data;
    }

    public Result(String code) {
        this.resultCd = code;
        this.resultMsg = MessageUtil.getMessage(CommonConts.MESSAGE_BASE_NAME.concat(code));
        this.result = null;
    }

    public Result(String code, String message) {
        this.resultCd = code;
        this.resultMsg = message;
        this.result = null;
    }

    public Result(String code, String message , T data) {
        this.resultCd = code;
        this.resultMsg = message;
        this.result = data;
    }
}
