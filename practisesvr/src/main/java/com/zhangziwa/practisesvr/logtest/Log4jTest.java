package com.zhangziwa.practisesvr.logtest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Log4jTest {
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        while (true) {
            Thread.sleep(1000);
            log.trace("这是测试trace" + i);
            log.debug("这是测试debug" + i);
            log.info("这是测试info" + i);
            log.warn("这是测试warn" + i);
            log.error("这是测试error" + i);
            log.fatal("这是测试fatal" + i);
            i++;
        }
    }
}
