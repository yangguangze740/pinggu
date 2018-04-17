package com.zhulin.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            SpringBeanUtil.context = applicationContext;
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanId) {
        return getContext().getBean(beanId);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getContext().getBean(clazz);
    }

    public static <T> T getBean(String beanId, Class<T> clazz) {
        return getContext().getBean(beanId, clazz);
    }
}
