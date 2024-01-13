package com.zhangziwa.practisesvr.interceptor;

import com.zhangziwa.practisesvr.utils.response.ResponseContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ResponsePostInterceptor implements HandlerInterceptor {

    //在Controller执行之前调用，如果返回false，controller不执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("***ResponsePostInterceptor.preHandle***");
        return true;
    }

    //controller执行之后，且页面渲染之前调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("***ResponsePostInterceptor.postHandle***");
        if (response.isCommitted()) {
            System.out.println("response is committed");
            return;
        }

        HttpHeaders headers = ResponseContext.getHeaders();
        if (headers != null) {
            headers.forEach((key, values) -> values.forEach((value) -> {
                if (!response.getHeaderNames().contains(key)) {
                    response.addHeader(key, value);
                }
            }));
        }

        if (ResponseContext.getResponseCode() != null) {
            response.setStatus(ResponseContext.getResponseCode().value());
        }
    }

    //页面渲染之后调用，一般用于资源清理操作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("***ResponsePostInterceptor.afterCompletion***");
        ResponseContext.clear();
    }
}
