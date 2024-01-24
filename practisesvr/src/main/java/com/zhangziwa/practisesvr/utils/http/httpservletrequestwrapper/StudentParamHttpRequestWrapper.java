package com.zhangziwa.practisesvr.utils.http.httpservletrequestwrapper;

import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.utils.JsonUtils;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StudentParamHttpRequestWrapper 是一个自定义的 HttpServletRequest 包装类，它继承或实现 HttpRequestWrapper 类，
 * 主要用于在处理 HTTP 请求时对学生的特定参数进行封装和预处理。此类允许开发者方便地获取、验证以及修改请求中的学生相关参数，
 * 提供了一种集中管理与学生信息相关的请求参数的方式。
 * 它主要用于解决以下问题：
 * 1. 对请求参数的统一管理和验证，例如检查学号（studentId）、姓名（name）等字段的有效性。
 * 2. 在过滤器、拦截器或控制器中便捷地访问和操作学生相关信息，无需重复解析原始请求参数。
 * 注意：此包装类的具体实现可能需要根据实际项目需求来调整。
 */
public class StudentParamHttpRequestWrapper extends HttpServletRequestWrapper {
    private final String body;

    public StudentParamHttpRequestWrapper(HttpServletRequest request, Student vo) {
        super(request);
        this.body = JsonUtils.toJson(vo);
    }

    @Override
    public String getCharacterEncoding() {
        String encoding = super.getCharacterEncoding();
        return encoding == null ? "utf-8" : encoding;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), getCharacterEncoding()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes(getCharacterEncoding()));
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }
}
