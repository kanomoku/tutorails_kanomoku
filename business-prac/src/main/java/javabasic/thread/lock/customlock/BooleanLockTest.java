package thread.lock.customlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

// 读书笔记摘自书名：Java高并发编程详解：多线程与架构设计 作者：汪文君
public class BooleanLockTest {
    //定义BooleanLock
    private final Lock lock = new BooleanLock();

    //使用try..finally语句块确保lock每次都能被正确释放
    public void syncMethod() {
        try {
            //加锁
            lock.lock();

            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");

            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable() {
        try {
            lock.lock(1000);
            System.out.println(currentThread() + " get the lock.");
            int randomInt = current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // （1）多个线程通过lock（）方法争抢锁
//        testLock();

        // （2）可中断被阻塞的线程
//        testInterrupt();

        // （3）阻塞的线程可超时
        testTimeout();
    }

    private static void testTimeout() throws InterruptedException {
        BooleanLockTest blt = new BooleanLockTest();

        new Thread(blt::syncMethod, "T1").start();
        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(blt::syncMethodTimeoutable, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }

    private static void testInterrupt() throws InterruptedException {
        BooleanLockTest blt = new BooleanLockTest();
        new Thread(blt::syncMethod, "T1").start();
        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(blt::syncMethod, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t2.interrupt();
    }

    private static void testLock() {
        BooleanLockTest blt = new BooleanLockTest();
        //定义一个线程并且启动
        IntStream.range(0, 10).mapToObj(i -> new Thread(blt::syncMethod)).forEach(Thread::start);
    }
}