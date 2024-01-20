package com.zhangziwa.practisesvr.utils.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.net.*;
import java.util.Arrays;

@Slf4j
public class UriUtils {

    /**
     * 判断给定的URL字符串是否符合特定要求：
     * - URL非空且格式正确
     * - 协议必须是HTTP或HTTPS
     * - 不允许环回地址（例如：127.0.0.1 或 ::1）
     *
     * @param urlStr 待校验的URL字符串
     * @return 如果URL满足上述条件，返回true；否则返回false
     * @throws IllegalArgumentException 当URL格式错误或主机未知时抛出异常
     */
    public boolean checkUrl(String urlStr) {
        if (StringUtils.isBlank(urlStr)) {
            return false;
        }

        URL url;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format: " + urlStr, e);
        }

        // 限制协议
        String protocol = url.getProtocol().toLowerCase();
        if (!Arrays.asList("http", "https").contains(protocol)) {
            return false;
        }

        try {
            InetAddress inetAddress = InetAddress.getByName(url.getHost());
            // 限制环回地址
            if (inetAddress.isLoopbackAddress()) {
                return false;
            }
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Unknown host: " + url.getHost(), e);
        }

        return true;
    }

    /**
     * 从给定的URL字符串中提取主机名。
     * 如果URL格式不正确，将返回一个空字符串（在优化前）或 null（在优化后建议版本），
     * 并记录相应的错误信息。
     * <p>
     * http://www.example.com:80/path/to/resource?query=param 返回 "www.example.com"
     *
     * @param urlStr 待解析的URL字符串
     * @return URL中的主机名部分，如果无法获取，则返回空字符串或null
     */
    public String getHost(String urlStr) {
        try {
            URI uri = new URI(urlStr);
            return uri.getHost();
        } catch (URISyntaxException e) {
            log.error("URISyntaxException occurred while parsing URL: {}", urlStr);
            return null; // 返回 null 表示无法解析主机名
        }
    }

    /**
     * 获取给定URL字符串中的端口号
     * <p>
     * "http://example.com:8081/path" → 8081
     *
     * @param urlStr 一个符合URI规范的URL字符串
     * @return 如果URL中指定了端口号，则返回指定的端口号；若未指定端口号，返回默认端口8080；
     * 若URL字符串格式不正确，抛出URISyntaxException时，记录异常信息并返回-1
     */
    public int getPort(String urlStr) {
        try {
            URI uri = new URI(urlStr);
            int port = uri.getPort();
            if (port == -1) {
                return 8080;
            }
            return port;
        } catch (URISyntaxException e) {
            // 异常情况下，记录异常信息，可以根据实际情况选择日志框架（如SLF4J、Log4j等）
            log.error("发生URL语法异常:{} " + e.getMessage());
            return -1;
        }
    }
}
