package com.zhangziwa.practisesvr.logtest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log_Injection {
    public static void main(String[] args) {
        String s = "Injection1\n\n测试日志注入1";
        String s1 = "Injection2\r\r测试日志注入2";
        String s2 = "Injection3\n\r\n\r测试日志注入3";

        log.info(s);
        System.out.println("处理逻辑1");
        log.info(s1);
        System.out.println("处理逻辑2");
        log.info(s2);

        System.out.println("--------------------------------");

        log.info(cleanMsg(s));
        System.out.println("处理逻辑3");
        log.info(cleanMsg(s1));
        System.out.println("处理逻辑4");
        log.info(cleanMsg(s2));
    }

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

