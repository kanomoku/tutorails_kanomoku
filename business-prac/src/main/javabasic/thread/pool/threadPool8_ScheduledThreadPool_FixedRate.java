package thread.pool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
