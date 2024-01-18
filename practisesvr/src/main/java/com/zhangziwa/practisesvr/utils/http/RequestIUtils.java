package com.zhangziwa.practisesvr.utils.http;

import com.zhangziwa.practisesvr.utils.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestIUtils {
    /**
     * 从当前请求上下文中获取并解析请求体数据，将其转换为Map类型对象.
     *
     * @return 如果成功获取到请求体数据并转换成功，则返回一个包含请求体内容的Map对象；
     * 若RequestAttributes不存在或请求体数据为空，则返回一个新的空HashMap对象。
     */
    public static Map<String, Object> getRequestBodyBody() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return new HashMap<>();
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        Object requestBody = request.getAttribute("requestBodyData");
        if (requestBody == null) {
            return new HashMap<>();
        }
        return JsonUtils.jsonToT(requestBody.toString(), Map.class);
    }

    private static HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public static void printRequestInfo() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return;
        }
        String method = request.getMethod();

        String url = request.getRequestURL().toString();

        String scheme = request.getScheme();

        String remoteHost = request.getRemoteHost();
        String serverName = request.getServerName();
        String localName = request.getLocalName();

        String remoteAddr = request.getRemoteAddr();
        String localAddr = request.getLocalAddr();

        int remotePort = request.getRemotePort();
        int serverPort = request.getServerPort();
        int localPort = request.getLocalPort();

        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        String queryString = request.getQueryString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> parameterNames = request.getParameterNames();

        String contentType = request.getContentType();

        int contentLength = request.getContentLength();

        Enumeration<String> encodings = request.getHeaders("Accept-Encoding");
        while (encodings.hasMoreElements()) {
            String encoding = encodings.nextElement();
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        String header = request.getHeader("User-Agent");
        int contentLength1 = request.getIntHeader("Content-Length");
        long date = request.getDateHeader("Date");

//        HttpServletMapping httpServletMapping = request.getHttpServletMapping();
//        String authType = request.getAuthType();
//        Cookie[] cookies = request.getCookies();
//        String pathTranslated = request.getPathTranslated();
//        String remoteUser = request.getRemoteUser();
//        boolean isUserInRole = request.isUserInRole();
//        Principal userPrincipal = request.getUserPrincipal();
//        String requestedSessionId = request.getRequestedSessionId();
//        HttpSession session = request.getSession();
//        boolean isRequestedSessionIdValid = request.isRequestedSessionIdValid();
//        boolean isRequestedSessionIdFromCookie = request.isRequestedSessionIdFromCookie();
//        boolean isRequestedSessionIdFromURL = request.isRequestedSessionIdFromURL();
//        Collection<Part> parts = request.getParts();
//        Part part = request.getPart();
//        Map<String, String> trailerFields = request.getTrailerFields();
//        boolean isTrailerFieldsReady = request.isTrailerFieldsReady();

        System.out.println(parameterMap.toString());
        System.out.println(url);
        System.out.println(method);
        System.out.println(requestURI);
        System.out.println(remoteAddr);
        System.out.println(localAddr);
        System.out.println(scheme);
        System.out.println(serverName);
        System.out.println(serverPort);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(queryString);
        System.out.println(remoteHost);
        System.out.println(parameterNames);
        System.out.println(header);
        System.out.println(contentLength);
        System.out.println(localPort);
        System.out.println(remotePort);
        System.out.println(localName);
        System.out.println(contentType);
        System.out.println(contentLength1);
        System.out.println(date);
        System.out.println(headerNames);
        System.out.println(pathInfo);
    }
}