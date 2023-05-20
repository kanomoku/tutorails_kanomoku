package thread.pool.newScheduledThreadPool;

import thread.pool.custom.Task;

import java.util.Date;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class FixedDelay {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        way1();
        way2();
    }

    private static void way2() {
        System.out.println(Thread.currentThread().getName() + "线程: Start at: " + new Date());

        ScheduledThreadPoolExecutor scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + " → " + " Start Time = " + new Date());
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " → " + " End   Time = " + new Date());
        }, 1, 4, TimeUnit.SECONDS);  // 初始延时 2s， 固定延时4s
    }

    private static void way1() {
        System.out.println(Thread.currentThread().getName() + "线程: Start at: " + new Date());

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleWithFixedDelay(new Task("任务"), 1, 4, TimeUnit.SECONDS);
    }
}
