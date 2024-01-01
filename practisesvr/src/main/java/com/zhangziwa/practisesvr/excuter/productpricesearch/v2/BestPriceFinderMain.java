package com.zhangziwa.practisesvr.excuter.productpricesearch.v2;

import com.zhangziwa.practisesvr.excuter.productpricesearch.v1.Shop;
import com.zhangziwa.practisesvr.utils.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();
    private final List<Shop> shops = new ArrayList<>();

    {
        for (int i = 0; i < 64; i++) {
            shops.add(new Shop("LetsSaveBig3" + i));
        }
        System.out.println(shops.size());
    }


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("性能比较");
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"), stopWatch);
        execute("parallelStream", () -> bestPriceFinder.findPricesParallel("myPhone27S"), stopWatch);
        execute("CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"), stopWatch);
        execute("CompletableFutureExecuter", () -> bestPriceFinder.findPricesFutureCustom("myPhone27S"), stopWatch);
        StopWatchUtils.logStopWatch(stopWatch);

//        execute("combined USD CompletableFuture", () -> bestPriceFinder.findPricesInUSD("myPhone27S"));
//        execute("combined USD CompletableFuture v2", () -> bestPriceFinder.findPricesInUSD2("myPhone27S"));
//        execute("combined USD CompletableFuture v3", () -> bestPriceFinder.findPricesInUSD3("myPhone27S"));
    }


    private static void execute(String msg, Supplier<List<String>> s, StopWatch stopWatch) {
        stopWatch.start(msg);
        System.out.println(s.get());
        stopWatch.stop();
    }
}
