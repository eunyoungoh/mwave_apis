package com.cjenm.mwave.apis.common.exception;

import com.cjenm.mwave.apis.common.constants.CommonConts;
import com.cjenm.mwave.apis.common.utils.MessageUtil;
import com.cjenm.mwave.apis.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = BizException.class)
    public ResponseEntity bizExceptionHandler(BizException ex) {
        ex.printStackTrace();               // 개발 단계에서만 출력.

        log.error("bizExceptionHandler : ", ex.getCode());

        return ResponseUtil.getResult(ex.getCode(), ex.getHttpStatus());
    }

    @ExceptionHandler(value = ServerException.class)
    public ResponseEntity serverExceptionHandler(ServerException ex) {
        ex.printStackTrace();               // 개발 단계에서만 출력.

        log.error("serverExceptionHandler : ", ex.getCode());

        return ResponseUtil.getResult(getCode(ex.getCode()), ex.getHttpStatus());
    }

    /**
     * validation 실패
     * Service validation 이용.
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationExceptionHandler(ConstraintViolationException ex) {
        ex.printStackTrace();               // 개발 단계에서만 출력.

        log.error("constraintViolationExceptionHandler : ");

        return ex.getConstraintViolations().stream()
            .findFirst()
            .map(cv -> {
                if (nonNull(cv.getRootBeanClass().getAnnotation(Service.class))) {
                    return ResponseUtil.getResult(
                        cv.getMessage()
                        , MessageUtil.getMessage(getCode(cv.getMessage()), cv.getPropertyPath().toString())
                        , HttpStatus.INTERNAL_SERVER_ERROR
                    );
                } else {
                    return ResponseUtil.getResult(
                        cv.getMessage()
                        , MessageUtil.getMessage(getCode(cv.getMessage()), cv.getPropertyPath().toString())
                        , HttpStatus.BAD_REQUEST
                    );
                }
            })
            .get();
    }

    /**
     * 잘못된 파라미미터 validation
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        ex.printStackTrace();               // 개발 단계에서만 출력.

        log.error("methodArgumentNotValidExceptionHandler : ", ex.getMessage());

        return ResponseUtil.getResult(
            CommonConts.RESULT_REQUIRED_CODE
            , MessageUtil.getMessage(getCode(CommonConts.RESULT_REQUIRED_CODE),
                ex.getBindingResult().getFieldErrors().stream()
                    .findFirst()
                    .filter(Objects::nonNull)
                    .map(error -> error.getField())
                    .orElse("")
            )
            , HttpStatus.BAD_REQUEST
        );

    }

    /**
     * requestParam 필수 설정시 발생.
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        ex.printStackTrace();               // 개발 단계에서만 출력.

        log.error("MissingServletRequestParameterException : ");

        return ResponseUtil.getResult(
            CommonConts.RESULT_REQUIRED_CODE
            , MessageUtil.getMessage(getCode(CommonConts.RESULT_REQUIRED_CODE), ex.getParameterName())
            , HttpStatus.BAD_REQUEST
        );
    }

    /**
     * 기타 Exception 500 처리
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(Exception ex) {
        ex.printStackTrace();               // 개발 단계에서만 출력.
        log.error("exceptionHandler : ", ex);

        return ResponseUtil.getResult(
            ex.getMessage()
            , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private String getCode(String code) {
        return CommonConts.MESSAGE_BASE_NAME.concat(code);
    }
}
