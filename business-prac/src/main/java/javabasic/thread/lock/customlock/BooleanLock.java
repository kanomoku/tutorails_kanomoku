package javabasic.thread.lock.customlock;

import java.util.*;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;


// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class BooleanLock implements Lock {
    private Thread currentThread;
    private boolean locked = false;
    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {//①
            while (locked) {//②
                blockedList.add(currentThread());
                this.wait();
            }
            blockedList.remove(currentThread());//③
            this.locked = true;//④
            this.currentThread = currentThread();//⑤
        }
    }

    public void lock1() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                //暂存当前线程
                final Thread tempThread = currentThread();
                try {
                    if (!blockedList.contains(tempThread)) {
                        blockedList.add(tempThread);
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    //如果当前线程在wait时被中断，则从blockedList中将其删除，避免内存泄漏
                    blockedList.remove(tempThread);
                    //继续抛出中断异常
                    throw e;
                }
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {//①
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0) {//②
                        throw new TimeoutException("can not get the lock during " + mills);
                    }
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                    }
                    this.wait(remainingMills); //③
                    remainingMills = endMills - currentTimeMillis(); //④
                }
                blockedList.remove(currentThread()); //⑤
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {//①
                this.locked = false; // ②
                Optional.of(currentThread() + " release the lock.").ifPresent(System.out::println);
                this.notifyAll(); // ③
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}