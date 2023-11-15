package javabasic.thread.exp.exp2.v4;

import javabasic.log.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("性能比较");
        execute("combined USD findPricesInUSDJava7", () -> bestPriceFinder.findPricesInUSDJava7("myPhone27S"), stopWatch);
        execute("combined USD CompletableFuture", () -> bestPriceFinder.findPricesInUSD("myPhone27S"), stopWatch);
        execute("combined USD CompletableFuture v2", () -> bestPriceFinder.findPricesInUSD2("myPhone27S"), stopWatch);
        execute("combined USD CompletableFuture v3", () -> bestPriceFinder.findPricesInUSD3("myPhone27S"), stopWatch);
        StopWatchUtils.logStopWatch(stopWatch);
    }


    private static void execute(String msg, Supplier<List<String>> s, StopWatch stopWatch) {
        stopWatch.start(msg);
        System.out.println(s.get());
        stopWatch.stop();
        System.out.println();
    }
}
