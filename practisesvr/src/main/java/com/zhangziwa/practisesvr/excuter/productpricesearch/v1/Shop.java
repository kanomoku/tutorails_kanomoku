package com.zhangziwa.practisesvr.excuter.productpricesearch.v1;


import com.zhangziwa.practisesvr.utils.thread.DelayUtils;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Data
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    // 依据指定产品名称返回价格,同步方法
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    // 依据指定产品名称返回价格,将同步方法转换为异步方法
    // 当前实现存在的问题：
    // 用于提示错误的异常会被限制在试图计算商品价格的当前线程的范围内，最终会杀死该线程，而这会导致等待get方法返回结果的客户端永久地被阻塞
    // 查询价格线程 终止，但 main 线程未停止，程序阻塞
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
//            double price = calculatePrice(product);  // 无异常场景
            double price = calculatePriceErr(product); // 发生异常场景
            futurePrice.complete(price); // 如果价格计算正常结束，完成Future操作并设置商品价格
        }, "查询价格线程").start();

        return futurePrice;
    }

    // 使用CompletableFuture的completeExceptionally方法将导致CompletableFuture内发生问题的异常抛出
    public Future<Double> getPriceAsync1(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePriceErr(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                System.out.println("log记录异常: " + ex.getMessage());
                futurePrice.completeExceptionally(ex); // 否则就抛出导致失败的异常，完成这次Future操作
            }
        }, "查询价格线程").start();

        return futurePrice;
    }

    // catch住Excetpion后一定要抛出去，不然也会阻塞死
    public Future<Double> getPriceAsync2(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePriceErr(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                System.out.println(DelayUtils.getMoment() + " " + ex.getMessage());
            }
        }, "查询价格线程").start();

        return futurePrice;
    }

    public Future<Double> getPriceAsync3(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePriceErr(product));
    }

    private double calculatePrice(String product) {
        DelayUtils.delay();
        System.out.println(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 执行calculatePrice");
        // 依据产品的名称，生成一个随机值作为价格
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private double calculatePriceErr(String product) {
        DelayUtils.delay();
        System.out.println(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 执行calculatePrice");

        // 模拟发生异常
        if (true) throw new RuntimeException(Thread.currentThread().getName() + " 模拟异常的异常信息");

        return 0;
    }
}
