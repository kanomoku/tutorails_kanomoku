package com.zhangziwa.practisesvr.utils.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static java.util.Objects.nonNull;

@ControllerAdvice
public class ResponsePostAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        System.err.println("***ResponsePostAdvice.supports***");
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class clazz, ServerHttpRequest request, ServerHttpResponse response) {
        System.err.println("***ResponsePostAdvice.beforeBodyWrite***");
        HttpHeaders headers = response.getHeaders();

        // 分页信息添加到ServerHttpResponse
        HttpHeaders headersContext = ResponseContext.getHeaders();

        // 实现方式1: 一次性梭哈 重复项新值覆盖旧值
//        if (nonNull(headersContext) && !headersContext.isEmpty()) {
//            headers.addAll(headersContext);
//        }

        // 实现方式1: 逐个补充 重复项不添加
        if (nonNull(headersContext) && !headersContext.isEmpty()) {
            headersContext.forEach((key, values) -> values.forEach((value) -> {
                headers.addIfAbsent(key, value);
            }));
        }

        // 状态码添加到ServerHttpResponse
        if (nonNull(ResponseContext.getResponseCode())) {
            response.setStatusCode(ResponseContext.getResponseCode());
        }
        return body;
    }
}
