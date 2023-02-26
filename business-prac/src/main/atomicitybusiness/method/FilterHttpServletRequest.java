package atomicitybusiness.method;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class FilterHttpServletRequest extends HttpServletRequestWrapper {
    private byte[] body;
    private ByteArrayInputStream byteArrayInputStream;
    private ServletInputStream servletInputStream;
    private BufferedReader bufferedReader;

    public FilterHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        this.body = readBytes(request.getInputStream());
        this.byteArrayInputStream = new ByteArrayInputStream(this.body);
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, 102400);
        return byteArrayOutputStream.toByteArray();
    }

    public static int copy(InputStream inputStream, OutputStream outputStream, long byteCount) throws IOException {
        if (inputStream == null || outputStream == null) {
            new Exception("流为空");
        }
        byte[] buffer = new byte[512];
        int totalSize = 0;
        int count;
        try {
            while ((count = inputStream.read(buffer, 0, 512)) != -1) {
                totalSize += count;
                if (totalSize > byteCount) {
                    new Exception("超过了最大字节数");
                }
                outputStream.write(buffer, 0, count);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                new Exception("close inputStream error");
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                new Exception("close outputStream error");
            }
        }
        return totalSize;
    }

    @Override public String getCharacterEncoding() {
        return Objects.isNull(super.getCharacterEncoding()) ? "utf-8" : super.getCharacterEncoding();
    }

    public String getBody() throws UnsupportedEncodingException {
        String characterEncoding = this.getCharacterEncoding();
        return new String(this.body, characterEncoding);
    }

    @Override public BufferedReader getReader() throws UnsupportedEncodingException {
        if (this.bufferedReader == null) {
            this.bufferedReader =
                new BufferedReader(new InputStreamReader(this.byteArrayInputStream, this.getCharacterEncoding()));
        }
        return this.bufferedReader;
    }

    @Override public ServletInputStream getInputStream() {
        if (this.servletInputStream == null) {
            this.servletInputStream = new ServletInputStream() {
                @Override public int read() throws IOException {
                    return FilterHttpServletRequest.this.byteArrayInputStream.read();
                }

                public boolean isFinished() {
                    return FilterHttpServletRequest.this.byteArrayInputStream.available() == 0;
                }

                public boolean isReady() {
                    return true;
                }
                //                public void setReadListener(ReadListener paramReadListener){}
            };
        }
        return this.servletInputStream;
    }
}
