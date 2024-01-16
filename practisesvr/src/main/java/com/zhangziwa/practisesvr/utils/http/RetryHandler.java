package com.zhangziwa.practisesvr.utils.http;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class RetryHandler implements HttpRequestRetryHandler {
    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount >= 2) {
            // 如果已经重试了2次，就放弃
            // Do not retry if over max retry count
            return false;
        }
        if (exception instanceof NoHttpResponseException) {
            // 如果服务器丢掉了连接，那么就重试
            return true;
        }
        if (exception instanceof SSLHandshakeException) {
            // 不要重试SSL握手异常
            return false;
        }
        if (exception instanceof SSLException) {
            // SSL握手异常
            // SSL handshake exception
            return false;
        }
        if (exception instanceof ConnectTimeoutException) {
            // 连接被拒绝
            return false;
        }
        if (exception instanceof InterruptedIOException) {
            // An input or output transfer has been terminated
            // 超时
            return false;
        }
        if (exception instanceof UnknownHostException) {
            // Unknown host 修改代码让不识别主机时重试，实际业务当不识别的时候不应该重试，再次为了演示重试过程，执行会显示retryCount次下面的输出
            // 目标服务器不可达
            System.out.println("不识别主机重试");
            return true;
        }
        if (exception instanceof ConnectException) {
            // Connection refused
            return false;
        }
        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        if (!(request instanceof HttpEntityEnclosingRequest)) {
            // Retry if the request is considered idempotent
            return true;
        }
        return false;
    }
}
