package com.zhangziwa.practisesvr.utils.filter;

import com.zhangziwa.practisesvr.utils.http.httpservletrequestwrapper.FilterHttpRequestBodyWrapper;
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
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 匹配上post /api/v1/user/login 则直接放行,主要体会ANT_PATH_MATCHER
        if ("POST".equalsIgnoreCase(httpRequest.getMethod()) && ANT_PATH_MATCHER.match("/api/v1/user/login", httpRequest.getRequestURI())) {
            chain.doFilter(httpRequest, response);
            return;
        }

        String contentType = httpRequest.getHeader("Content-Type");
        if (contentType != null && contentType.contains("application/x-www-form-urlencoded")) {
            // 请求数据是表单提交格式
            // 这里要放行,不然原生的HttpServletRequest对象中的输入流(getInputStream())只能被读取一次，会被FilterHttpRequestBodyWrapper消耗,从而Controller层读取不到数据
            chain.doFilter(httpRequest, response);
            return;
        } else if (contentType != null && contentType.contains("application/json")) {
            // 请求数据是 JSON 格式
        } else if (contentType != null && contentType.contains("text/plain")) {
            // 请求数据是纯文本格式
        } else if (contentType != null && contentType.contains("application/xml")) {
            // 请求数据是 XML 格式
        } else {
            // 请求数据格式未知
        }

        FilterHttpRequestBodyWrapper filterHttpRequest = new FilterHttpRequestBodyWrapper(httpRequest);
        String body = filterHttpRequest.getBodyByteArr();
        filterHttpRequest.setAttribute("requestBodyData", body);

        // 继续执行filter链
        chain.doFilter(filterHttpRequest, response);

        System.err.println("***RequestHeaderCheckFilter.doFilter.end***");
    }
}