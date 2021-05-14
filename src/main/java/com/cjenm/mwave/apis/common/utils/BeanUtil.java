package com.cjenm.mwave.apis.common.utils;

import com.cjenm.mwave.apis.common.component.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

public class BeanUtil {
    public static Object getBean( String beanName ){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        return applicationContext.getBean(beanName);
    }
}
