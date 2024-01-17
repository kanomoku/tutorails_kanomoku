package com.zhangziwa.practisesvr.utils.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Instant;

// @Component 注册时会new 这里无需指定 registration.setFilter(new LogFilter());
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("***LogFilter.doFilter.start***");
        HttpServletRequest httpReq = (HttpServletRequest) request;
        long startTime = Instant.now().toEpochMilli();

        // 记录请求开始时间及请求信息
        log.warn("LogFilter.doFilter: Start processing request at {} - {}", Instant.now(), httpReq.getRequestURI());

        try {
            // 将请求传递给下一个过滤器或目标资源
            chain.doFilter(request, response);
        } finally {
            // 记录请求结束时间及响应状态码
            long endTime = Instant.now().toEpochMilli();
            int statusCode = ((HttpServletResponse) response).getStatus();
            log.warn("LogFilter.doFilter: Finished processing request at {} - {} in {} ms. Status code: {}", Instant.now(), httpReq.getRequestURI(), (endTime - startTime), statusCode);
        }
        System.err.println("***LogFilter.doFilter.end***");
    }
}
