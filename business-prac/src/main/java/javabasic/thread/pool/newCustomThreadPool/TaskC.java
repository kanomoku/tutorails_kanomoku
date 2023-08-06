package javabasic.thread.pool.newCustomThreadPool;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 功能概要：缓冲线程池实例-submit运行
 */
public class TaskC implements Callable<String> {
    private final String name;

    public TaskC(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " → " + name + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " → " + name + " End   Time = " + new Date());
        return "返回结果" + Thread.currentThread().getName() + " → " + name;
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
