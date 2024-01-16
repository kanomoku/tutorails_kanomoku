package com.zhangziwa.practisesvr.excuter.productpricesearch.v1;

import com.zhangziwa.practisesvr.utils.log.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.zhangziwa.practisesvr.utils.thread.DelayUtils.getMoment;

public class ShopMain {

    public static void main(String[] args) {
        async();
//        sync();
    }

    // 同步实现
    private static void sync() {
        Shop shop = new Shop("BestShop");
        StopWatch stopWatch = new StopWatch("串行用时统计");

        stopWatch.start("getPrice");
        double price = shop.getPrice("product name");
        System.out.printf(getMoment() + " " + Thread.currentThread().getName() + " Price is %.2f%n", price);
        stopWatch.stop();

        stopWatch.start("doSomethingElse");
        // 模拟其他业务逻辑
        doSomethingElse();
        stopWatch.stop();

        StopWatchUtils.logStopWatch(stopWatch);
    }

    // 异步实现
    private static void async() {
        Shop shop = new Shop("BestShop");
        StopWatch stopWatch = new StopWatch("并行用时统计");

        stopWatch.start("getPrice new a thread and start");
        Future<Double> futurePrice = shop.getPriceAsync("product name");
        stopWatch.stop();

        stopWatch.start("doSomethingElse");
        doSomethingElse();
        stopWatch.stop();

        stopWatch.start("futurePrice.get()");
        try {
            double price = futurePrice.get();
            System.out.printf(getMoment() + " " + Thread.currentThread().getName() + " Price is %.2f%n", price);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();

        StopWatchUtils.logStopWatch(stopWatch);
    }


    private static void doSomethingElse() {
        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " Do some more tasks, like querying other shops...");
    }
}
