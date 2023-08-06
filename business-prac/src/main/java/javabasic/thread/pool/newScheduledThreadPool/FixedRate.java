package javabasic.thread.pool.newScheduledThreadPool;

import javabasic.thread.pool.newCustomThreadPool.Task;

import java.util.Date;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class FixedRate {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        way1();
        way2();
    }

    private static void way2() {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " → " + " Start Time = " + new Date());
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " → " + " End   Time = " + new Date());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 1, 4, TimeUnit.SECONDS);
    }

    private static void way1() {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(new Task("任务"), 1, 4, TimeUnit.SECONDS); // 初始延时 1s， 周期4s
    }
}
