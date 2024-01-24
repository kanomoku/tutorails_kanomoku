package com.zhangziwa.practisesvr.utils.http.httpservletrequestwrapper;

import com.zhangziwa.practisesvr.utils.stream.StreamIUtils;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.text.StringEscapeUtils;

import java.io.*;

public class FilterHttpRequestBodyWrapper extends HttpServletRequestWrapper {
    private final byte[] bodyByteArr; // 字节数组
    private final ByteArrayInputStream byteArrayInputStream; // 从字节数组读取数据的输入流

    private BufferedReader bufferedReader; // getReader()
    private ServletInputStream servletInputStream; // getInputStream()

    public FilterHttpRequestBodyWrapper(HttpServletRequest request) throws IOException {
        super(request);
        bodyByteArr = StreamIUtils.readStream2Bytes(request.getInputStream());
        byteArrayInputStream = new ByteArrayInputStream(bodyByteArr);
    }

    public String getBodyByteArr() throws UnsupportedEncodingException {
        return new String(bodyByteArr, getCharacterEncoding());
    }

    /**
     * 覆盖父类方法，实现获取参数时自动对参数值进行XSS攻击过滤。
     *
     * @param name 参数名
     * @return 如果参数存在，则返回经过HTML转义的、已过滤XSS攻击的参数值；若参数不存在，则返回null
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value != null) {
            // 使用StringEscapeUtils.escapeHtml4对请求参数进行XSS攻击过滤
            return StringEscapeUtils.escapeHtml4(value);
        }
        return null;
    }

    /**
     * 重写父类的getCharacterEncoding方法，获取请求的字符编码。
     * 若当前请求的字符编码未设置或为空，则默认返回"utf-8"作为字符编码。
     *
     * @return 请求的字符编码，若原编码为空则返回"utf-8"
     */
    @Override
    public String getCharacterEncoding() {
        String encoding = super.getCharacterEncoding();
        return encoding == null ? "utf-8" : encoding;
    }

    /**
     * 重写父类或接口中的getReader方法，提供一个BufferedReader对象。
     *
     * @return 返回一个根据请求体内容和字符编码方式创建的BufferedReader对象
     */
    @Override
    public BufferedReader getReader() {
        if (bufferedReader == null) {
            try {
                // 封装一个BufferedReader对象以提高读取效率
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, getCharacterEncoding()));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Unsupported encoding: ", e);
            }
        }
        return bufferedReader;
    }

    /**
     * 重写父类的 getInputStream 方法，提供一个自定义的 ServletInputStream 实例，
     * 该实例从内部的 byteArrayInputStream 中读取数据，并支持监听器模式。
     *
     * @return 自定义的 ServletInputStream 实例，用于读取请求体数据
     */
    @Override
    public ServletInputStream getInputStream() {
        // 确保 servletInputStream 的初始化在多线程环境下是安全的
        if (servletInputStream == null) {
            synchronized (this) {
                // 创建并初始化一个 ServletInputStream 子类实例
                servletInputStream = new ServletInputStream() {
                    /**
                     * 从内部的 byteArrayInputStream 中读取下一个字节数据
                     *
                     * @return 下一个可读字节，如果已到达流末尾则返回 -1
                     * @throws IOException 如果发生输入/输出错误
                     */
                    @Override
                    public int read() throws IOException {
                        return byteArrayInputStream.read();
                    }

                    /**
                     * 判断是否已经读取完所有数据，即 byteArrayInputStream 是否还有可用数据
                     *
                     * @return 如果没有更多数据可供读取，则返回 true；否则返回 false
                     */
                    public boolean isFinished() {
                        return byteArrayInputStream.available() == 0;
                    }

                    /**
                     * 指示此输入流是否准备好进行读取操作
                     *
                     * @return 始终返回 true，表示此输入流始终处于就绪状态
                     */
                    public boolean isReady() {
                        return true;
                    }

                    /**
                     * 设置 ReadListener 监听器，用于异步读取数据。此处未实现具体逻辑。
                     *
                     * @param readListener 用于处理数据读取事件的 ReadListener 实例
                     */
                    @Override
                    public void setReadListener(ReadListener readListener) {
                    }
                };
            }
        }
        return servletInputStream;
    }
}
