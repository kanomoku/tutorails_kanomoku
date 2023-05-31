package thread.lock.deadlock;

import static java.lang.Thread.currentThread;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class DeadLock2 {
    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(currentThread().getName() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(currentThread().getName() + " get WRITE lock");
            }
            System.out.println(currentThread().getName() + " release WRITE lock");
        }
        System.out.println(currentThread().getName() + " release READ lock");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(currentThread().getName() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(currentThread().getName() + " get READ lock");
            }
            System.out.println(currentThread().getName() + " release READ lock");
        }
        System.out.println(currentThread().getName() + " release WRITE lock");
    }

    public static void main(String[] args) {
        final DeadLock2 deadLock = new DeadLock2();
        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }, "READ-THREAD").start();

        new Thread(() -> {
            while (true) {
                deadLock.write();
            }
        }, "WRITE-THREAD").start();
    }
}