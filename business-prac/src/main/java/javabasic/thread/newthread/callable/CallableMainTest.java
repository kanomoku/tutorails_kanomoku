package javabasic.thread.newthread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableMainTest {
    public static void main(String[] args) {

        CallableRunningMan myThread1 = new CallableRunningMan("小明");
        FutureTask<Integer> futureTask1 = new FutureTask<>(myThread1);

        CallableRunningMan myThread2 = new CallableRunningMan("小明");
        FutureTask<Integer> futureTask2 = new FutureTask<>(myThread2);

        new Thread(futureTask1).start();
        new Thread(futureTask2).start();

        try {
            System.out.println(Thread.currentThread().getName() + "返回值" + futureTask1.get());
            System.out.println(Thread.currentThread().getName() + "返回值" + futureTask2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
