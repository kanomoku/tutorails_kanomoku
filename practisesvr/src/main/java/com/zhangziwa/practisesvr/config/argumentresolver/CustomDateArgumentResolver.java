package com.zhangziwa.practisesvr.config.argumentresolver;

import org.apache.http.client.utils.DateUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Date;

public class CustomDateArgumentResolver implements HandlerMethodArgumentResolver {
    private static final String[] format = {"yyyy-MM-dd"};
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 获取传入参数的类型
        Class<?> type = parameter.getParameterType();
        // 如果参数类型有为Student类的则符合,进入resolveArgument方法
        return Date.class == type;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 从请求中获取日期字符串，并转换为Date对象
        return DateUtils.parseDate(webRequest.getParameter("date"), format);
    }
}