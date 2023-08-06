package javabasic.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableOneTaskMainTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<String> oneCallable1 = new CallableOneTask("小明");
        FutureTask<String> futureTask1 = new FutureTask<>(oneCallable1);
        Callable<String> oneCallable2 = new CallableOneTask("小明");
        FutureTask<String> futureTask2 = new FutureTask<>(oneCallable2);
        Callable<String> oneCallable3 = new CallableOneTask("小明");
        FutureTask<String> futureTask3 = new FutureTask<>(oneCallable3);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();

        while (!futureTask1.isDone() && !futureTask2.isDone() && !futureTask3.isDone()) {
            System.out.println("检查线程执行完了吗...");
            Thread.sleep(1000);
        }

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
    }

}
