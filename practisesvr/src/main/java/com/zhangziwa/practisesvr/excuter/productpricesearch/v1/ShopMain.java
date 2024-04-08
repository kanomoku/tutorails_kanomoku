package com.zhangziwa.practisesvr.excuter.productpricesearch.v1;

import com.zhangziwa.practisesvr.utils.log.StopWatchUtils;
import com.zhangziwa.practisesvr.utils.thread.DelayUtils;
import org.springframework.util.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class ShopMain {

    public static void main(String[] args) {
        async();
//        sync();
    }

    // 同步实现
    private static void sync() {
        Shop shop = new Shop("大雁小卖店");
        StopWatch stopWatch = new StopWatch("同步实现");

        stopWatch.start("查询商品价格");
        double price = shop.getPrice("虾条");
        System.out.printf(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 获取Price is %.2f%n", price);
        stopWatch.stop();

        stopWatch.start("其他业务处理");
        // 模拟其他业务逻辑
        DelayUtils.delay();
        System.out.println(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 Do some more tasks, like querying other shops...");
        stopWatch.stop();

        StopWatchUtils.logStopWatch(stopWatch);
    }

    // 异步实现
    private static void async() {
        Shop shop = new Shop("大雁小卖店");
        StopWatch stopWatch = new StopWatch("异步实现用时统计");

        stopWatch.start("发起异步查询商品价格");
        Future<Double> futurePrice = shop.getPriceAsync1("虾条");
        stopWatch.stop();

        stopWatch.start("其他业务处理");
        // 模拟其他业务逻辑
        DelayUtils.delay();
        System.out.println(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 Do some more tasks, like querying other shops...");
        stopWatch.stop();

        stopWatch.start("获取异步查询结果");
        try {
            System.out.println(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 获取异步结果futurePrice.get()");
            double price = futurePrice.get();
            System.out.printf(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 获取Price is %.2f%n", price);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();

        StopWatchUtils.logStopWatch(stopWatch);
    }

    private static void doSomethingElse() {
        System.out.println(DelayUtils.getMoment() + " " + Thread.currentThread().getName() + "线程 Do some more tasks, like querying other shops...");
    }
}
