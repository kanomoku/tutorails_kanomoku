package com.zhangziwa.practisesvr.utils.response;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


public class ResponseUtils {
    private static ThreadLocal<HttpHeaders> ThreadLocalHeaders = new InheritableThreadLocal<>();
    private static ThreadLocal<HttpStatus> ThreadLocalStatus = new InheritableThreadLocal<>();

    public static void addHeaders(String key, String value) {
        if (ThreadLocalHeaders.get() == null) {
            ThreadLocalHeaders.set(new HttpHeaders());
        }
        ThreadLocalHeaders.get().add(key, value);
    }

    public static void setResponseCode(HttpStatus httpStatus) {
        ThreadLocalStatus.set(httpStatus);
    }

    public static HttpHeaders getHeaders() {
        return ThreadLocalHeaders.get();
    }

    public static HttpStatus getResponseCode() {
        return ThreadLocalStatus.get();
    }

    public static void clear() {
        if (ThreadLocalHeaders.get() != null) {
            ThreadLocalHeaders.remove();
        }
        if (ThreadLocalStatus.get() != null) {
            ThreadLocalStatus.remove();
        }
    }
}
