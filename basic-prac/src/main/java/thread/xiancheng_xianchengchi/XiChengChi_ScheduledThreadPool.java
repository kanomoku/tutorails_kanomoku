package thread.xiancheng_xianchengchi;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
 * -调度型线程池-这个池子里的线程可以按schedule依次delay执行，或周期执行
 */
public class XiChengChi_ScheduledThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10); // 创建大小为10的线程池
        for (int i = 0; i < 10; i++) {
            System.out.println("添加了第" + i + "个线程 "+ new Date());
            exec.schedule(new XiChengChi_Handle("线程名字" + i), 10, TimeUnit.SECONDS);// 延迟10秒执行
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
