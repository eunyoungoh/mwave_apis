package com.cjenm.mwave.apis.common.utils;

import com.cjenm.mwave.apis.common.model.Result;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    /**
     * 응답 데이터 없이 성공 결과, 메세지 리턴.(성공)
     * @return
     */
    public static ResponseEntity getResult(){
        return new ResponseEntity(new Result(), HttpStatus.OK);
    }

    /**
     * 결과, 메세지, 데이터 리턴.(성공)
     * @param data
     * @return
     */
    public static ResponseEntity getResult(Object data){
        return new ResponseEntity(new Result(data), HttpStatus.OK);
    }

    /**
     * 에러 용으로 코드에 따른 메세지와 httpStatus 리턴.
     * @param code
     * @param httpStatus
     * @return
     */
    public static ResponseEntity getResult(String code, HttpStatus httpStatus){
        return new ResponseEntity(new Result(code), httpStatus);
    }

    /**
     * 에러 용으로 코드에 따른 메세지와 httpStatus 리턴.
     * @param code
     * @param httpStatus
     * @return
     */
    public static ResponseEntity getResult(String code,String message, HttpStatus httpStatus){
        return new ResponseEntity(new Result(code, message), httpStatus);
    }
}
