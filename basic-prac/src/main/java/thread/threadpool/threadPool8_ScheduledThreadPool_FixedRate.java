package thread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程初始化延迟1s才开始执行，每隔2s重新执行一次任务。
 * 如果任务用时3秒的话，这个超过间隔的2秒，就直接执行了，如果是用时1秒的话就还需要再等1秒
 */
public class threadPool8_ScheduledThreadPool_FixedRate {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        for (int i = 1; i < 4; i++) {
            System.out.println("添加了第" + i + "个线程任务  " + new Date());
            executor.scheduleAtFixedRate(new threadPool1_Handle("线程名字" + i), 1, 4, TimeUnit.SECONDS);// 这里的2秒值得是时间过了2秒，而不是某个线程的时间片累计2秒。
        }
        System.out.println(Thread.currentThread().getName() + "线程: 打卡 " + new Date());
        while (!executor.isTerminated()) {
            // wait for all tasks to finish
        }
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}