package com.zhangziwa.practisesvr.utils.log;

import com.zhangziwa.practisesvr.excuter.summation.ForkJoinSumCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.function.Function;

@Slf4j
public class StopWatchUtils {
    public static void logStopWatch(StopWatch stopWatch) {
        System.out.println(String.format("%s total cost time : %s ms", stopWatch.getId(), stopWatch.getTotalTimeMillis()));
//        log.info("{} total cost time = {}} ms", stopWatch.getId(), stopWatch.getTotalTimeMillis());
        for (StopWatch.TaskInfo taskInfo : stopWatch.getTaskInfo()) {
            String present = String.format("%.2f", (float) taskInfo.getTimeMillis() / stopWatch.getTotalTimeMillis() * 100);
            System.out.println(String.format("%s cost : %s ms, %s%%", postFillSpace(taskInfo.getTaskName()), taskInfo.getTimeMillis(), present));
//            log.info("{} cost : {} ms, {}%", postFillSpace(taskInfo.getTaskName()), taskInfo.getTimeMillis(), present);
        }
    }

    public static String postFillSpace(String str) {
        if (str.length() >= 40) {
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

        System.out.println(measureDuration(ForkJoinSumCalculator::forkJoinSum, 10_000_000L));
    }

    // 传统统计用时实现方案
    public static <T, R> R measureDuration(Function<T, R> f, T input) {
        long start = System.nanoTime();
        R result = f.apply(input);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("执行用时 " + duration + " seconds");
        return result;
    }


    // 测量性能
    // 这个方法接受一个函数和一个参数。调用10次，记录每次执行的时间（以毫秒为单位），并返回最短的一次执行时间
    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R sum = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result：" + sum);

            if (duration < fastest) {
                fastest = duration;
            }
        }

        return fastest;
    }
}
