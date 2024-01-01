package com.zhangziwa.practisesvr.excuter.productpricesearch.v1;


import com.zhangziwa.practisesvr.utils.DelayUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Future;

import static com.zhangziwa.practisesvr.utils.DelayUtils.getMoment;

public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    // 用于提示错误的异常会被限制在试图计算商品价格的当前线程的范围内，最终会杀死该线程，而这会导致等待get方法返回结果的客户端 永久地被阻塞
    // Thread-0终止，但 main 线程未停止，程序阻塞
    public Future<Double> getPrice(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();

        return futurePrice;
    }

    // 使用CompletableFuture的completeExceptionally方法将导致CompletableFuture内发生问题的异常抛出
    public Future<Double> getPrice1(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                futurePrice.completeExceptionally(ex); // 否则就抛出导致失败的异常，完成这次Future操作
            }
        }).start();

        return futurePrice;
    }

    // catch住Excetpion后一定要抛出去，不然也会阻塞死
    public Future<Double> getPrice2(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                System.out.println(getMoment() + " " + ex.getMessage());
            }
        }).start();

        return futurePrice;
    }

    public Future<Double> getPrice3(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public Future<Double> getPrice4(String product) {
        CompletableFuture<Double> futurePrice = CompletableFuture
                .supplyAsync(() -> calculatePrice(product))
                .exceptionally(e -> {
                    CompletionException ex = new CompletionException(e);
                    System.out.println("自定义项目调用异常：" + e.getMessage());
                    throw ex;
                });
        return futurePrice;
    }

    private double calculatePrice(String product) {
        DelayUtils.delay();
        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " 执行线程任务");
        if (true) throw new RuntimeException(Thread.currentThread().getName() + "模拟异常的异常信息");
        return DelayUtils.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}