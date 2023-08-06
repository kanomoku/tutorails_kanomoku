package javabasic.thread.pool.newCachedThreadPool;

import javabasic.thread.pool.newCustomThreadPool.Task;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getName() + "线程: Start at: " + new Date());

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 1; i < 10; i++) {
            System.out.println("添加了第" + i + "个任务类");
            Thread.sleep(2);
            exec.execute(new Task("线程名字" + i));
        }

        exec.shutdown();

        System.out.println(Thread.currentThread().getName() + " 线程: Finished all threads at：" + new Date());
    }
}