package com.zhangziwa.practisesvr.utils;

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
}
