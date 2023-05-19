package thread.pool.newSingleThreadExecutor;

import thread.pool.custom.Task;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Start at: " + new Date());

        ExecutorService exec = Executors.newSingleThreadExecutor();
        // 等价于 ExecutorService exec = Executors.newFixedThreadPool(1);

        for (int i = 1; i < 10; i++) {
            System.out.println("添加了第" + i + "个任务类");
            exec.execute(new Task(String.valueOf(i)));
        }

        exec.shutdown();

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date() + ". isTerminated 判断次数 ");
    }
}
