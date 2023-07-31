package thread.lock.deadlock;

import java.util.Date;

public class DeadLock {
    private static Object resource1 = new Object();// 资源 1
    private static Object resource2 = new Object();// 资源 2

    public static void main(String[] args) {
//        deadLock();

        // 破坏循环等待条件
        breakDeadLock();
    }


    /**
     * 会死锁
     */
    private static void deadLock() {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get resource1 at " + new Date());
                waitMs(1000);
                System.out.println(Thread.currentThread().getName() + " will get resource2 at " + new Date());
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource2 at " + new Date());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " get resource2 at " + new Date());
                waitMs(1000);
                System.out.println(Thread.currentThread().getName() + " will get resource1 at " + new Date());
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " get resource1 at " + new Date());
                }
            }
        }).start();
    }

    private static void waitMs(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 破坏循环等待条件
     */
    private static void breakDeadLock() {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get resource1 at " + new Date());
                waitMs(1000);
                System.out.println(Thread.currentThread().getName() + " will get resource2 at " + new Date());
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource2 at " + new Date());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get resource1 at " + new Date());
                waitMs(1000);
                System.out.println(Thread.currentThread().getName() + " will get resource2 at " + new Date());
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource2 at " + new Date());
                }
            }
        }).start();
    }
}
