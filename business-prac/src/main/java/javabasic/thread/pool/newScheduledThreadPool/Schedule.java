package javabasic.thread.pool.newScheduledThreadPool;

import javabasic.thread.pool.newCustomThreadPool.Task;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Schedule {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getName() + "线程: Start at: " + new Date());

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            System.out.println("添加了第" + i + "个线程任务 " + new Date());
            scheduledThreadPoolExecutor.schedule(new Task("线程名字" + i), 10, TimeUnit.SECONDS);// 延迟10秒执行
        }

        scheduledThreadPoolExecutor.shutdown();

        System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());

        while (!scheduledThreadPoolExecutor.isTerminated()) {
            // wait for all tasks to finish
        }

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}
