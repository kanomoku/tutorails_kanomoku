package com.zhangziwa.practisesvr.utils.filter;

import com.zhangziwa.practisesvr.utils.http.FilterHttpServletRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

//@Component 注册时会new 这里无需指定 registration.setFilter(new RequestCheckFilter());
public class RequestCheckFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("***RequestHeaderCheckFilter.doFilter.start***");

        if (!(request instanceof HttpServletRequest)) {
            throw new IllegalStateException("Expected HttpServletRequest");
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        FilterHttpServletRequest filterHttpRequest = new FilterHttpServletRequest(httpRequest);
        String body = filterHttpRequest.getBody();
        filterHttpRequest.setAttribute("requestBodyData", body);

        // 继续执行filter链
        chain.doFilter(filterHttpRequest, response);

        System.err.println("***RequestHeaderCheckFilter.doFilter.end***");
    }
}