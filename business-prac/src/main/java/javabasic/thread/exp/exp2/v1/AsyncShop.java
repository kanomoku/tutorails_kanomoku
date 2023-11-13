package javabasic.thread.exp.exp2.v1;

import javabasic.thread.exp.exp2.Util;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

//    public Future<Double> getPrice(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//
//        new Thread(() -> {
//            double price = calculatePrice(product);
//            futurePrice.complete(price);
//        }).start();
//
//        return futurePrice;
//    }

//    public Future<Double> getPrice(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage());
//                futurePrice.completeExceptionally(ex); // 否则就抛出导致失败的异常，完成这次Future操作
//            }
//        }).start();
//
//        return futurePrice;
//    }

//    public Future<Double> getPrice(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage());
//            }
//        }).start();
//
//        return futurePrice;
//    }

    public Future<Double> getPrice(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

//    public Future<Double> getPrice(String product) {
//        CompletableFuture<Double> futurePrice = CompletableFuture
//                .supplyAsync(() -> calculatePrice(product))
//                .exceptionally(e -> {
//                    CompletionException ex = new CompletionException(e);
//                    System.out.println("自定义项目调用异常：" + e.getMessage());
//                    throw ex;
//                });
//        return futurePrice;
//    }

    private double calculatePrice(String product) {
        Util.delay();
        System.out.println(Thread.currentThread().getName() + " 执行线程任务");
        if (true) throw new RuntimeException(Thread.currentThread().getName() + "模拟异常的异常信息");
        return Util.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

}