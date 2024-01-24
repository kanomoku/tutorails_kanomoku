package com.zhangziwa.practisesvr.utils.filter;

import com.zhangziwa.practisesvr.utils.http.FilterHttpServletRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

//@Component 注册时会new 这里无需指定 registration.setFilter(new RequestCheckFilter());
public class RequestCheckFilter extends GenericFilterBean {

    public static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("***RequestHeaderCheckFilter.doFilter.start***");
        if (!(request instanceof HttpServletRequest httpRequest)) {
            chain.doFilter(request, response);
            return;
        }

        // 匹配上post /api/v1/user/login 则直接放行
        if ("POST".equalsIgnoreCase(httpRequest.getMethod())
                && ANT_PATH_MATCHER.match("/api/v1/user/login", httpRequest.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        FilterHttpServletRequest filterHttpRequest = new FilterHttpServletRequest(httpRequest);
        String body = filterHttpRequest.getBody();
        filterHttpRequest.setAttribute("requestBodyData", body);

        // 继续执行filter链
        chain.doFilter(filterHttpRequest, response);

        System.err.println("***RequestHeaderCheckFilter.doFilter.end***");
    }
}