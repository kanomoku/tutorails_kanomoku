package com.zhangziwa.practisesvr.excuter.productpricesearch.v2;

import com.zhangziwa.practisesvr.utils.log.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("性能比较");
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"), stopWatch);
        execute("parallelStream", () -> bestPriceFinder.findPricesParallel("myPhone27S"), stopWatch);
        execute("CompletableFuture", () -> bestPriceFinder.findPricesCompletableFuture("myPhone27S"), stopWatch);
        execute("CompletableFutureExecuterSize", () -> bestPriceFinder.findPricesCompletableFutureCustomSize("myPhone27S"), stopWatch);
        execute("CompletableFutureExecuter100", () -> bestPriceFinder.findPricesCompletableFutureCustom100("myPhone27S"), stopWatch);
        execute("CompletableFutureExecuterProcessors", () -> bestPriceFinder.findPricesCompletableFutureCustomProcessors("myPhone27S"), stopWatch);
        StopWatchUtils.logStopWatch(stopWatch);

//        execute("combined USD CompletableFuture", () -> bestPriceFinder.findPricesInUSD("myPhone27S"));
//        execute("combined USD CompletableFuture v2", () -> bestPriceFinder.findPricesInUSD2("myPhone27S"));
//        execute("combined USD CompletableFuture v3", () -> bestPriceFinder.findPricesInUSD3("myPhone27S"));
    }


    private static void execute(String msg, Supplier<List<String>> s, StopWatch stopWatch) {
        stopWatch.start(msg);
        List<String> res = s.get();
//        res.forEach(System.out::println);
//        System.out.println(x);
        stopWatch.stop();
    }
}
