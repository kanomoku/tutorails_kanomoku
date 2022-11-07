package thread.xiancheng_xianchengchi;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程化的Executor。
 * <p>
 * -单例线程，任意时间池中只能有一个线程
 * -用的是和cache池和fixed池相同的底层池，但线程数目是 1-1,0秒IDLE（无IDLE）
 */
public class XiChengChi_SingleThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        ExecutorService exec = Executors.newSingleThreadExecutor(); // 创建大小为1的固定线程池
        // 等价于 ExecutorService exec = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            System.out.println("添加了第" + i + "个线程");
            exec.execute(new XiChengChi_Handle(String.valueOf(i)));
        }
        exec.shutdown(); // 执行到此处并不会马上关闭线程池
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}
// 其实这个就是创建只能运行一条线程的线程池。它能保证线程的先后顺序执行，并且能保证一条线程执行完成后才开启另一条新的线程

