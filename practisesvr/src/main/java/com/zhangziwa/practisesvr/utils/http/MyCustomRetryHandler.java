package com.zhangziwa.practisesvr.utils.http;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class MyCustomRetryHandler implements HttpRequestRetryHandler {
    private final int maxRetries;

    public MyCustomRetryHandler(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount >= maxRetries) {
            // 如果已超过最大重试次数，则不再重试
            return false;
        }

        // UnknownHostException extends IOException
        if (exception instanceof UnknownHostException) {
            // DNS解析错误（UnknownHostException）
            // 实际应用中，DNS解析错误一般不应该重试，因为短时间内再次尝试解析同一个无效域名很可能会得到相同的结果。
            return false;
        }

        // SSLHandshakeException extends SSLException
        if (exception instanceof SSLHandshakeException) {
            // SSL握手失败（SSLHandshakeException）：
            // 如果发生SSL/TLS握手错误，通常不建议自动重试，
            // 因为这可能是由于证书验证失败、协议版本不匹配或其他安全相关问题导致的。
            return false;
        }
        // SSLException extends IOException
        if (exception instanceof SSLException) {
            // SSL异常（SSLException）：
            // SSL异常一般不会是临时问题，因为SSL握手失败一般不会恢复，因此不建议重试。
            return false;
        }

        // NoHttpResponseException extends IOException
        if (exception instanceof NoHttpResponseException) {
            // 服务器过载或临时不可用
            // 这些情况下，可以根据实际情况决定是否进行重试。
            return true;
        }

        // ConnectionPoolTimeoutException extends ConnectTimeoutException
        if (exception instanceof ConnectionPoolTimeoutException) {
            // 连接池获取连接超时，可重试
            return true;
        }
        // ConnectTimeoutException extends InterruptedIOException
        if (exception instanceof ConnectTimeoutException) {
            // 服务器过载或临时不可用
            // 这些情况下，可以根据实际情况决定是否进行重试。
            return true;
        }
        // SocketTimeoutException extends InterruptedIOException
        if (exception instanceof SocketTimeoutException) {
            // 对于超时异常，也可以选择重试
            return true;
        }
        // InterruptedIOException extends IOException
        if (exception instanceof InterruptedIOException) {
            // 对于中断的IO异常（如SocketTimeoutException），不进行重试
            return false;
        }


        // HttpHostConnectException extends ConnectException
        if (exception instanceof HttpHostConnectException) {
            // 这类异常可能包括网络中断、连接关闭等，根据具体情况进行重试。
            return true;
        }
        // ConnectException extends SocketException
        if (exception instanceof ConnectException) {
            // Connection refused
            return false;
        }
        // SocketException extends IOException
        if (exception instanceof SocketException) {
            // 这类异常可能包括网络中断、连接关闭等，根据具体情况进行重试。
            return true;
        }

        // 检查请求是否幂等
        HttpCoreContext coreContext = HttpCoreContext.adapt(context);
        HttpRequest request = coreContext.getRequest();
        if (request instanceof HttpRequestWrapper wrapper) {
            HttpUriRequest originalRequest = (HttpUriRequest) wrapper.getOriginal();
            String method = originalRequest.getMethod();
            if ("GET".equals(method) || "HEAD".equals(method) || "PUT".equals(method) || "DELETE".equals(method)) {
                // 幂等请求，可根据实际情况决定是否重试
                return true;
            }
        }
        if (!(request instanceof HttpEntityEnclosingRequest)) {
            // 幂等请求，可根据实际情况决定是否重试
            return true;
        }

        int[] RETRYABLE_STATUS_CODES = {500, 503, 504};
        // 如果是HTTP响应错误并且在可重试的状态码列表中，则重试
        Object attribute = context.getAttribute(HttpClientContext.HTTP_RESPONSE);
        if (attribute instanceof CloseableHttpResponse response) {
            StatusLine statusLine = response.getStatusLine();
            return Arrays.stream(RETRYABLE_STATUS_CODES).anyMatch(status -> status == statusLine.getStatusCode());
        }

        return false;
    }
}
