package javabasic.thread.exp.exp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FutureTaskWorker {
    // 查看处理器数
    private static final int processors = Runtime.getRuntime().availableProcessors();

    // 定义线程池
    private static final ExecutorService executor = Executors.newFixedThreadPool(processors + 1);

    static {
        // 查看一下机器处理器数
        System.out.println(processors + " processors");
    }

    public static <T, R> List<R> handle(List<T> tasks, Function<T, R> function) {
        List<CompletableFuture<R>> featureRes = new ArrayList<>();
        for (T task : tasks) {
            // 任务添加到线程池
            CompletableFuture<R> feature = CompletableFuture.supplyAsync(() -> function.apply(task), executor);
            featureRes.add(feature);
        }

        List<R> res = new ArrayList<>();
        try {
            // 等所有任务执行完成
            CompletableFuture.allOf(featureRes.toArray(new CompletableFuture[0])).get();

            // 收集执行结果
            for (CompletableFuture<R> feature : featureRes) {
                res.add(feature.get());
            }
            return res;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void shunDown() {
        executor.shutdownNow();
    }

    public static <T, R> List<R> handle1(List<T> tasks, Function<T, R> function) {
        List<CompletableFuture<R>> futureList = tasks.stream().map(task -> CompletableFuture.supplyAsync(() -> function.apply(task), executor)).collect(Collectors.toList());
        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        return allCompletableFuture.thenApply(e -> futureList.stream().map(CompletableFuture::join).collect(Collectors.toList())).join();
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("小明1");
        names.add("小明2");
        names.add("小明3");
        names.add("小明4");
        names.add("小明5");
        names.add("小明6");
        names.add("小明7");
        names.add("小明8");
        names.add("小明9");

        try {
            List<String> res = handle(names, name -> businessMethod(name));
            res.forEach(System.out::println);
        } finally {
            shunDown();
        }
    }

    public static String businessMethod(String str) {
        System.out.println(Thread.currentThread().getName() + "线程：" + new Date());
        return str + "  " + new Date();
    }
}
