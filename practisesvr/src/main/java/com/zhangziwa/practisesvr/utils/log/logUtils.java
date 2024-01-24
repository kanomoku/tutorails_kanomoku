package com.zhangziwa.practisesvr.utils.log;

import com.zhangziwa.practisesvr.utils.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class logUtils {

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

    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String buildApiJsonLog(HttpServletRequest request, HttpServletResponse response, long cost) {
        Map<String, Object> apiJsonMap = new LinkedHashMap<>();
        apiJsonMap.put("traceId", LogContext.getTraceId());
        apiJsonMap.put("end_date", DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.now()));
        apiJsonMap.put("cost", cost);
        apiJsonMap.put("remoteHost", request.getRemoteHost());
        apiJsonMap.put("remoteAddr", request.getRemoteAddr());
        apiJsonMap.put("remotePort", request.getRemotePort());
        apiJsonMap.put("method", request.getMethod());
        apiJsonMap.put("requestURI", request.getRequestURI());
        apiJsonMap.put("status", response.getStatus());
        apiJsonMap.put("requestContentLength", request.getContentLengthLong());
        apiJsonMap.put("sql_count", LogContext.getSqlCount());
        apiJsonMap.put("sql_cost", LogContext.getSqlCost());
        apiJsonMap.put("sql_searched_row_count", LogContext.getSqlSearchedRowCount());
        if (Boolean.TRUE.equals(ThreadMXBeanUtils.isThreadCpuTimeEnabled())) {
            apiJsonMap.put("currentThreadTime", ThreadMXBeanUtils.getCurrentThreadTime());
            apiJsonMap.put("currentThreadUserTime", ThreadMXBeanUtils.getCurrentThreadUserTime());
        }
        if (Boolean.TRUE.equals(ThreadMXBeanUtils.isThreadAllocatedMemoryEnabled())) {
            apiJsonMap.put("currentThreadAllocatedBytes", ThreadMXBeanUtils.getCurrentThreadAllocatedBytes());
        }
        return JsonUtils.toJson(apiJsonMap);
    }
}
