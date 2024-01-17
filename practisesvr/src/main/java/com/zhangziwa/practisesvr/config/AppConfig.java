package com.zhangziwa.practisesvr.config;

import com.github.pagehelper.PageInterceptor;
import com.zhangziwa.practisesvr.utils.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        // 分页合理化，true开启，如果分页参数不合理会自动修正。默认false不启用
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean
    public FilterRegistrationBean<LogFilter> logFilterRegistration() {
        FilterRegistrationBean<LogFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LogFilter());
        // 可以设置过滤器名称
        registration.setName("logFilter");
        // 设置拦截规则
        registration.addUrlPatterns("/*"); // 拦截所有请求
        // 设置过滤器执行顺序，默认为0，数值越小优先级越高
        registration.setOrder(1);
        return registration;
    }
}
