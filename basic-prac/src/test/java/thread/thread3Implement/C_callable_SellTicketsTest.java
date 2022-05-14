package thread.thread3Implement;

import org.junit.After;
import org.junit.Before;

import java.util.concurrent.FutureTask;

public class C_callable_SellTicketsTest {

    public static void main(String[] args) {

        test1();

//        test2();
    }

    private static void test1() {
        C_callable_SellTickets myThread1 = new C_callable_SellTickets();
        C_callable_SellTickets myThread2 = new C_callable_SellTickets();
        FutureTask<Integer> futureTask1 = new FutureTask<>(myThread1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myThread2);
        new Thread(futureTask1, "有返回值的线程1").start();
        new Thread(futureTask2, "有返回值的线程2").start();

        try {
            System.out.println(Thread.currentThread().getName() + " 线程  返回值： " + futureTask1.get());
            System.out.println(Thread.currentThread().getName() + " 线程  返回值： " + futureTask2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        C_callable_SellTickets myThread1 = new C_callable_SellTickets();
        FutureTask<Integer> futureTask1 = new FutureTask<>(myThread1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myThread1);
        new Thread(futureTask1, "有返回值的线程1").start();
        new Thread(futureTask2, "有返回值的线程2").start();

        try {
            System.out.println(Thread.currentThread().getName() + " 线程  返回值： " + futureTask1.get());
            System.out.println(Thread.currentThread().getName() + " 线程  返回值： " + futureTask2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before public void setUp() throws Exception {
    }

    @After public void tearDown() throws Exception {
    }
}