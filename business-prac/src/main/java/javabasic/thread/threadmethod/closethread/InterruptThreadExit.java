package javabasic.thread.threadmethod.closethread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work. → " + new Date());
                while (!isInterrupted()) {
                    //working.
                }
                System.out.println("I will be exiting. → " + new Date());
            }
        };
        t.start();

        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown. → " + new Date());
        t.interrupt();
    }
}