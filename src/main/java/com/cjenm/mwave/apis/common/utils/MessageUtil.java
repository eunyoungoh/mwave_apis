package com.cjenm.mwave.apis.common.utils;

import com.cjenm.mwave.apis.common.constants.CommonConts;
import com.cjenm.mwave.apis.common.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Slf4j
public class MessageUtil {

    /**
     * 메세지를 가져온다.
     * @param code
     * @return
     */
    public static String getMessage(String code){
        return getMsg(code, null);
    }

    /**
     * 메세지를 가져온다.
     * @param code
     * @param args
     * @return
     */
    public static String getMessage(String code, String...args){
        return getMsg(code, args);
    }

    private static <P extends Object> String getMsg(String code, String [] args){
        MessageSource messageSource = (MessageSource) BeanUtil.getBean(CommonConts.MESSAGE_BEAN_NAME);

        if (messageSource == null) {
            log.error("Message Bean Creation Error");
            throw new ServerException("900");
        }
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
