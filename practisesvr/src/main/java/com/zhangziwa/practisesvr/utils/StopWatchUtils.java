package com.zhangziwa.practisesvr.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
public class StopWatchUtils {
    public static void logStopWatch(StopWatch stopWatch) {
        String format = String.format("%s total cost time = %s ms", stopWatch.getId(), stopWatch.getTotalTimeMillis());
        System.out.println(format);
        log.info("{} total cost time = {}} ms", stopWatch.getId(), stopWatch.getTotalTimeMillis());
        for (StopWatch.TaskInfo taskInfo : stopWatch.getTaskInfo()) {
            String present = String.format("%.2f", (float) taskInfo.getTimeMillis() / stopWatch.getTotalTimeMillis() * 100);
            String format1 = String.format("%s cost : %s ms, %s%%", postFillSpace(taskInfo.getTaskName()), taskInfo.getTimeMillis(), present);
            System.out.println(format1);
            log.info("{} cost : {} ms, {}%", postFillSpace(taskInfo.getTaskName()), taskInfo.getTimeMillis(), present);
        }
    }

    public static String postFillSpace(String str) {
        if (str.length() >= 10) {
            return str;
        }
        return postFillSpace(str + " ");
    }

    public static void main(String[] args) {
        // 创建StopWatch
        StopWatch stopWatch = new StopWatch("任务组名称");

        // 采集子任务用时
        stopWatch.start("事前准备");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            stopWatch.stop();
        }

        // 采集子任务用时
        for (int i = 0; i < 5; i++) {
            stopWatch.start("子任务" + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                stopWatch.stop();
            }
        }

        // 记录耗时信息
        StopWatchUtils.logStopWatch(stopWatch);
    }
}
