package javabasic.thread.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 功能概要：理解FutureTask的作用
 */
public class WorkerMainTest {
    public static void main(String args[]) throws ExecutionException, InterruptedException {

        Worker worker = new Worker();
        FutureTask<Integer> farmer = new FutureTask<>(worker);//FutureTask<String>是一个包装器，它通过接受Callable<String>来创建，它同时实现了Future和Runnable接口
        new Thread(farmer, "闰土: ").start();

        while (!farmer.isDone()) {
            System.out.println(Thread.currentThread().getName() + ": 看长工做完了没...");
            Thread.sleep(500);// 地主也就是main线程
        }

        System.out.println("工作做完了,上交了" + farmer.get() + "斤粮食");
    }
}
