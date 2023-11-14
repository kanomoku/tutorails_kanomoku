package javabasic.thread.exp.exp2.v3;

import javabasic.log.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("性能比较");
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"), stopWatch);
        execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"), stopWatch);
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"), stopWatch);
        execute("composed printPricesStream", () -> bestPriceFinder.printPricesStream("myPhone27S"), stopWatch);
        StopWatchUtils.logStopWatch(stopWatch);
    }

    private static void execute(String msg, Supplier<List<String>> s, StopWatch stopWatch) {
        stopWatch.start(msg);
        System.out.println(s.get());
        stopWatch.stop();
        System.out.println();
    }
}
