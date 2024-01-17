package com.zhangziwa.practisesvr.utils.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;

@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.err.println("***LogInterceptor.preHandle***");
        long startTime = Instant.now().toEpochMilli();
        request.setAttribute("startTime", startTime);
        log.warn("LogInterceptor.postHandle: Start processing request at {} - {}", Instant.now(), request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.err.println("***LogInterceptor.postHandle***");
        // 获取请求开始时间
        Long startTime = (Long) request.getAttribute("startTime");
        if (startTime != null) {
            long executionTime = Instant.now().toEpochMilli() - startTime;
            int statusCode = response.getStatus();
            log.warn("LogInterceptor.postHandle: Finished processing request at {} - {} in {} ms. Status code: {}", Instant.now(), request.getRequestURI(), executionTime, statusCode);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("***LogInterceptor.afterCompletion***");
        // 在此可以添加额外的后处理逻辑，但本例中我们不需要
    }
}
