package javabasic.thread.pool.newCustomThreadPool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "线程: Start at: " + new Date());

        // 创建等待队列
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(20);

        // 创建线程池、池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, blockingQueue);

        // 创建七个任务
        // 每个任务会在一个线程上执行
        for (int i = 1; i < 10; i++) {
            System.out.println("添加了第" + i + "个任务类");
            pool.execute(new Task("线程任务" + i));
        }

        // 关闭线程池
        pool.shutdown();

        System.out.println(Thread.currentThread().getName() + "线程: 打卡：" + new Date());

        long i = 0;
        while (!pool.isTerminated()) {
            // wait for all tasks to finish
            i++;
        }

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date() + ". isTerminated 判断次数 " + i);
    }
}