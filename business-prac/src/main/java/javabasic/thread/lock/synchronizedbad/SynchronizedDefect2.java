package javabasic.thread.lock.synchronizedbad;

import java.util.concurrent.TimeUnit;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class SynchronizedDefect2 {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefect defect = new SynchronizedDefect();

        Thread t1 = new Thread(defect::syncMethod, "T1");
        t1.start();

        //make sure the t1 started.
        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(defect::syncMethod, "T2");
        t2.start();

        //make sure the t2 started.
        TimeUnit.MILLISECONDS.sleep(2);

        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}