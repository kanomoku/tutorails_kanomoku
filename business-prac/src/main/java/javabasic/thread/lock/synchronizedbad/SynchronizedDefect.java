package javabasic.thread.lock.synchronizedbad;

import java.util.concurrent.TimeUnit;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class SynchronizedDefect {
    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefect defect = new SynchronizedDefect();
        Thread t1 = new Thread(defect::syncMethod, "T1");
        //make sure the t1 started.
        t1.start();

        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(defect::syncMethod, "T2");
        t2.start();
    }
}