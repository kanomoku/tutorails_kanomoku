package com.zhangziwa.practisesvr.utils.http;

import com.zhangziwa.practisesvr.utils.stream.StreamIUtils;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.text.StringEscapeUtils;

import java.io.*;

public class FilterHttpServletRequest extends HttpServletRequestWrapper {
    private final byte[] body;
    private ByteArrayInputStream byteArrayInputStream;
    private ServletInputStream servletInputStream;
    private BufferedReader bufferedReader;

    public FilterHttpServletRequest(HttpServletRequest request) throws Exception {
        super(request);
        body = StreamIUtils.readStream2Bytes(request.getInputStream());
        byteArrayInputStream = new ByteArrayInputStream(body);
    }

    public String getBody() throws UnsupportedEncodingException {
        String characterEncoding = this.getCharacterEncoding();
        return new String(body, characterEncoding);
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
            // 对请求参数值进行XSS过滤
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
        // 调用父类的getCharacterEncoding方法获取字符编码
        String encoding = super.getCharacterEncoding();
        // 如果字符编码为空，则默认为utf-8
        return encoding == null ? "utf-8" : encoding;
    }

    /**
     * 重写父类或接口中的getReader方法，提供一个BufferedReader对象。
     *
     * @return 返回一个根据请求体内容和字符编码方式创建的BufferedReader对象
     */
    @Override
    public BufferedReader getReader() {
        // 如果输入流尚未初始化，则使用请求体内容创建一个新的ByteArrayInputStream
        if (byteArrayInputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(body);
        }

        // 如果BufferedReader还未创建，则进行以下逻辑：
        if (bufferedReader == null) {
            // 获取当前请求的字符编码方式
            String characterEncoding = getCharacterEncoding();

            try {
                // 使用获取到的字符编码方式以及已有的ByteArrayInputStream创建一个InputStreamReader对象
                // 并在此基础上封装一个BufferedReader对象以提高读取效率
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, characterEncoding));
            } catch (UnsupportedEncodingException e) {
                // 若遇到不支持的字符编码异常，捕获并抛出一个包含详细错误信息的RuntimeException
                throw new RuntimeException("Unsupported encoding: " + characterEncoding, e);
            }
        }

        // 返回已经创建好的BufferedReader对象
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
                        // 留给子类实现
                    }
                };
            }
        }
        // 返回已初始化的 servletInputStream
        return this.servletInputStream;
    }
}
