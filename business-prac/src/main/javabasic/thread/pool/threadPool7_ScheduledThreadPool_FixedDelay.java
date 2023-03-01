package thread.pool;

import java.util.Date;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class threadPool7_ScheduledThreadPool_FixedDelay {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);


//        executor.scheduleWithFixedDelay(new threadPool1_Handle("线程名字" + 0), 1, 4, TimeUnit.SECONDS);  // 延迟 1s，周期 2s

        for (int i = 1; i < 11; i++) {
            System.out.println("添加了第" + i + "个线程任务 " + new Date());
            executor.scheduleWithFixedDelay(new threadPool1_Handle("线程名字" + i), 2, 4, TimeUnit.SECONDS);
        }

        System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());

//        while (!executor.isTerminated()) {
//            // wait for all tasks to finish
//        }

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}
