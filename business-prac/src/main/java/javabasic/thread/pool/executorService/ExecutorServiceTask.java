package javabasic.thread.pool.executorService;

import javabasic.thread.pool.newCustomThreadPool.Task;
import javabasic.thread.pool.newCustomThreadPool.TaskC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doExecute();
        doSubmit();
        doSubmitCallable();

        doInvokeAny();
        doInvokeAll();
    }

    private static void doExecute() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(Thread.currentThread().getName() + " 开始 → " + " Time = " + new Date());

        executorService.execute(new Task("任务"));
        System.out.println(Thread.currentThread().getName() + " 结束 → " + " Time = " + new Date());

        executorService.shutdown();
    }

    private static void doSubmit() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(Thread.currentThread().getName() + " 开始 → " + " Time = " + new Date());

        executorService.submit(new Task("任务"));
        System.out.println(Thread.currentThread().getName() + " 结束 → " + " Time = " + new Date());

        executorService.shutdown();
    }

    private static void doSubmitCallable() throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("添加了第" + i + "个线程任务");
            Future<String> future = executorService.submit(new TaskC("name"));
            resultList.add(future);
        }

        executorService.shutdown();

        System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());

        for (Future<String> fs : resultList) {
            System.out.println(fs.get());
        }

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }


    private static void doInvokeAll() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<String>> resultList = new ArrayList<>();

        resultList.add(new TaskC("Task1"));
        resultList.add(new TaskC("Task2"));
        resultList.add(new TaskC("Task3"));
        resultList.add(new TaskC("Task4"));
        List<Future<String>> futures = executorService.invokeAll(resultList);

        for (Future<String> future : futures) {
            System.out.println("future.get = " + future.get());
        }
        executorService.shutdown();
    }

    private static void doInvokeAny() throws InterruptedException, ExecutionException {
        // invokeAny(…)
        // invokeAny将第一个得到的结果作为返回值，然后立刻终止所有的线程。如果设置了超时时间，未超时完成则正常返回结果，如果超时未完成则报超时异常。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<String>> resultList = new ArrayList<>();

        resultList.add(new TaskC("Task1"));
        resultList.add(new TaskC("Task2"));
        resultList.add(new TaskC("Task3"));
        resultList.add(new TaskC("Task4"));
        String result = executorService.invokeAny(resultList);
        System.out.println("result = " + result);
        executorService.shutdown();
    }
}
