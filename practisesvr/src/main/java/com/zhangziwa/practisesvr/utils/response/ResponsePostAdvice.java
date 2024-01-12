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
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class clazz,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        HttpHeaders headers = response.getHeaders();

        // 分页信息添加到ServerHttpResponse
        HttpHeaders headersContext = ResponseContext.getHeaders();
        if (nonNull(headersContext) && !headersContext.isEmpty()) {
            headers.addAll(headersContext);
        }

        // 状态码添加到ServerHttpResponse
        if (nonNull(ResponseContext.getResponseCode())) {
            response.setStatusCode(ResponseContext.getResponseCode());
        }
        return body;
    }
}
