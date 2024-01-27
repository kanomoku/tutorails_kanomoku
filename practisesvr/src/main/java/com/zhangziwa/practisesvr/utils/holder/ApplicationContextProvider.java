package com.zhangziwa.practisesvr.utils.holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextProvider.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据名称获取Bean
     *
     * @param name Bean的名称
     * @return 返回指定名称的Bean
     */
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }


    /**
     * 从Spring上下文中根据类型获取Bean。
     *
     * @param clazz 要获取的Bean的类型
     * @param <T>   Bean的类型
     * @return 返回找到的Bean实例
     * @throws BeansException 在获取Bean失败时抛出异常
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        // 检查参数是否为null
        if (clazz == null) {
            throw new IllegalArgumentException("Class cannot be null.");
        }

        // 使用ApplicationContext获取指定类型的Bean
        return applicationContext.getBean(clazz);
    }

    /**
     * 从Spring上下文中获取指定名称和类型的Bean。
     *
     * @param name  Bean的名称
     * @param clazz Bean的类型
     * @param <T>   Bean的类型
     * @return 返回找到的Bean实例
     * @throws BeansException 在获取Bean失败时抛出异常
     */
    public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
        // 检查参数是否为null
        if (name == null || clazz == null) {
            throw new IllegalArgumentException("Name and class cannot be null.");
        }
        // 使用ApplicationContext获取指定名称和类型的Bean
        return applicationContext.getBean(name, clazz);
    }
}

