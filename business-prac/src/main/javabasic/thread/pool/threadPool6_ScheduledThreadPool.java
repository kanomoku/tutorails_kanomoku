package thread.pool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadPool6_ScheduledThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5); // 创建大小为5的线程池

        for (int i = 0; i < 10; i++) {
            System.out.println("添加了第" + i + "个线程任务 " + new Date());
            exec.schedule(new threadPool1_Handle("线程名字" + i), 10, TimeUnit.SECONDS);// 延迟10秒执行
        }

        exec.shutdown(); // 执行到此处并不会马上关闭线程池

        System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());

        while (!exec.isTerminated()) {
            // wait for all tasks to finish
        }

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
// 实现每个放入的线程延迟10秒执行。
}
