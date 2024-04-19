package com.zhangziwa.practisesvr.excuter.productpricesearch.v4;

import com.zhangziwa.practisesvr.utils.log.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.function.Supplier;

import static com.zhangziwa.practisesvr.utils.thread.DelayUtils.getMoment;

public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("性能比较");
        execute("combined USD thenCombine", () -> bestPriceFinder.findPricesInUSD("myPhone27S"), stopWatch);
        execute("combined USD thenCombine+thenApply", () -> bestPriceFinder.findPricesInUSD2("myPhone27S"), stopWatch);
        execute("combined USD thenCombine+thenApply+toList+supplyAsyncExecutor", () -> bestPriceFinder.findPricesInUSD4("myPhone27S"), stopWatch);
        execute("combined USD thenCombine+thenApply+toList+supplyAsync", () -> bestPriceFinder.findPricesInUSD3("myPhone27S"), stopWatch);
        execute("combined USD Java7", () -> bestPriceFinder.findPricesInUSDJava7("myPhone27S"), stopWatch);
        StopWatchUtils.logStopWatch(stopWatch);
    }


    private static void execute(String msg, Supplier<List<String>> s, StopWatch stopWatch) {
        stopWatch.start(msg);
        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " " + s.get());
        stopWatch.stop();
        System.out.println();
    }
}
