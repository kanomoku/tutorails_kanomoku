package com.zhangziwa.practisesvr.utils.log;

import com.zhangziwa.practisesvr.utils.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class logUtils {
    private static final DateTimeFormatter ISO_ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    /**
     * 获取净化后的消息，过滤掉换行，避免日志注入
     */
    public static String cleanMsg(String message) {
        if (message == null) {
            return "";
        }

        message = message.replace('\n', '_').replace('\r', '_');
        return message;
    }

    public static String generateUUIDString() {
        try {
            return UUID.randomUUID().toString().replace("-", "");
        } catch (Exception e) {
            throw new RuntimeException("Unable to generate a UUID", e);
        }
    }

    public static String buildApiJsonLog(HttpServletRequest request, HttpServletResponse response, long cost) {
        if (request == null || response == null) {
            throw new IllegalArgumentException("Request or response is null");
        }

        Map<String, Object> apiJsonMap = new LinkedHashMap<>();
        apiJsonMap.put("traceId", LogContext.getTraceId());
        apiJsonMap.put("endDate", ISO_ZONED_DATE_TIME_FORMATTER.format(ZonedDateTime.now()));
        apiJsonMap.put("cost", cost);
        apiJsonMap.put("remoteHost", request.getRemoteHost());
        apiJsonMap.put("remoteAddr", request.getRemoteAddr());
        apiJsonMap.put("remotePort", request.getRemotePort());
        apiJsonMap.put("method", request.getMethod());
        apiJsonMap.put("requestURI", request.getRequestURI());
        apiJsonMap.put("status", response.getStatus());
        apiJsonMap.put("requestContentLength", request.getContentLengthLong());
        apiJsonMap.put("sqlCount", LogContext.getSqlCount());
        apiJsonMap.put("sqlCost", LogContext.getSqlCost());
        apiJsonMap.put("sqlSearchedRowCount", LogContext.getSqlSearchedRowCount());

        if (Boolean.TRUE.equals(ThreadMXBeanUtils.isThreadCpuTimeEnabled())) {
            apiJsonMap.put("currentThreadTime", ThreadMXBeanUtils.getCurrentThreadTime());
            apiJsonMap.put("currentThreadUserTime", ThreadMXBeanUtils.getCurrentThreadUserTime());
        }

        if (Boolean.TRUE.equals(ThreadMXBeanUtils.isThreadAllocatedMemoryEnabled())) {
            apiJsonMap.put("currentThreadAllocatedBytes", ThreadMXBeanUtils.getCurrentThreadAllocatedBytes());
        }
        return JsonUtils.toJson(apiJsonMap);
    }

    public static void logInfo(String message) {
        log.info(message);
    }
}
