package com.zhangziwa.practisesvr.utils.interceptor;

import com.zhangziwa.practisesvr.utils.log.LogContext;
import com.zhangziwa.practisesvr.utils.log.ThreadMXBeanUtils;
import com.zhangziwa.practisesvr.utils.log.logUtils;
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

        LogContext.setTraceId(logUtils.genUUID());
        LogContext.initSqlCost();
        LogContext.initSqlCost();
        if (Boolean.TRUE.equals(ThreadMXBeanUtils.isThreadCpuTimeEnabled())) {
            LogContext.initCurrentThreadTime();
            LogContext.initCurrentThreadUserTime();
        }
        if (Boolean.TRUE.equals(ThreadMXBeanUtils.isThreadAllocatedMemoryEnabled())) {
            LogContext.initAllocatedBytes();
        }

        long startTime = Instant.now().toEpochMilli();
        request.setAttribute("startTime", startTime);

        log.warn("LogInterceptor.postHandle: Start processing request at {} - {}", Instant.now(), request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.err.println("***LogInterceptor.postHandle***");
        // 获取请求开始时间
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("***LogInterceptor.afterCompletion***");

        // 获取请求开始时间
        Long startTime = (Long) request.getAttribute("startTime");
        long executionCost = 0L;
        if (startTime != null) {
            executionCost = Instant.now().toEpochMilli() - startTime;
            int statusCode = response.getStatus();
            log.warn("LogInterceptor.postHandle: Finished processing request at {} - {} in {} ms. Status code: {}", Instant.now(), request.getRequestURI(), executionCost, statusCode);
        }

        String apiJson = logUtils.buildApiJsonLog(request, response, executionCost);
        log.info(apiJson);
        LogContext.clear();
    }
}
