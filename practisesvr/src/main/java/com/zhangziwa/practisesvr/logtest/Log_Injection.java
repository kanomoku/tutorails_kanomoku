package com.zhangziwa.practisesvr.logtest;

import lombok.extern.slf4j.Slf4j;

import static com.zhangziwa.practisesvr.utils.log.logUtils.cleanMsg;

@Slf4j
public class Log_Injection {
    public static void main(String[] args) {
        String s1 = "Injection1\n\n测试日志注入1";
        String s2 = "Injection2\n\r测试日志注入2";
        String s3 = "Injection3\n\r\n\r测试日志注入3";

        log.info(s1);
        System.out.println("---------------上下文分隔符-----------------");
        log.info(s2);
        System.out.println("---------------上下文分隔符-----------------");
        log.info(s3);

        log.info(cleanMsg(s1));
        System.out.println("---------------上下文分隔符-----------------");
        log.info(cleanMsg(s2));
        System.out.println("---------------上下文分隔符-----------------");
        log.info(cleanMsg(s3));

    }

}

