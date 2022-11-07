package thread.xiancheng_xianchengchi;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 以固定延迟时间进行执行 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务。 不管你执行用了多久，我都会再等10秒的
 */
public class XiChengChi_ScheduledThreadPool_ExecuteFixedDelay {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        for (int i = 1; i < 4; i++) {
            System.out.println("添加了第" + i + "个线程 "+ new Date());
            executor.scheduleWithFixedDelay(new XiChengChi_Handle("线程名字" + i), 2, 10, TimeUnit.SECONDS);
        }
        System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());
        while (!executor.isTerminated()) {
            // wait for all tasks to finish
        }
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}
