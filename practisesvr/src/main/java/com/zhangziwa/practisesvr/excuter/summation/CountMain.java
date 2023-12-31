package com.zhangziwa.practisesvr.excuter.summation;

import com.zhangziwa.practisesvr.utils.StopWatchUtils;
import org.springframework.util.StopWatch;

import java.util.function.Function;

public class CountMain {
    public static <T, R> void measurePerf(Function<T, R> f, T input) {
        for (int i = 0; i < 10; i++) {
            f.apply(input);
        }
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("任务组名称");

        stopWatch.start("forkJoinSum");
        // ForkJoinSumCalculator.forkJoinSum(10_000_000L);
        measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000L);
        stopWatch.stop();

        stopWatch.start("sequentialIterativeSum");
        // ParallelStreams.sequentialIterativeSum(10_000_000L);
        measurePerf(ParallelStreams::sequentialIterativeSum, 10_000_000L);
        stopWatch.stop();

        stopWatch.start("iterateSequentialReduceSum");
        // ParallelStreams.iterateSequentialReduceSum(10_000_000L);
        measurePerf(ParallelStreams::iterateSequentialReduceSum, 10_000_000L);
        stopWatch.stop();

        stopWatch.start("iterateParallelReduceSum");
        // ParallelStreams.iterateParallelReduceSum(10_000_000L);
        measurePerf(ParallelStreams::iterateParallelReduceSum, 10_000_000L);
        stopWatch.stop();

        stopWatch.start("rangedSequentialReduceSum");
        // ParallelStreams.rangedSequentialReduceSum(10_000_000L);
        measurePerf(ParallelStreams::rangedSequentialReduceSum, 10_000_000L);
        stopWatch.stop();
        stopWatch.start("rangedParallelReduceSum");
        // ParallelStreams.rangedParallelReduceSum(10_000_000L);
        measurePerf(ParallelStreams::rangedParallelReduceSum, 10_000_000L);
        stopWatch.stop();

        stopWatch.start("sequentialAccumulatorSum");
        // ParallelStreams.sequentialAccumulatorSum(10_000_000L);
        measurePerf(ParallelStreams::sequentialAccumulatorSum, 10_000_000L);
        stopWatch.stop();

        stopWatch.start("parallelAccumulatorSum");
         // ParallelStreams.parallelAccumulatorSum(10_000_000L);
        measurePerf(ParallelStreams::parallelAccumulatorSum, 10_000_000L);
        stopWatch.stop();

        StopWatchUtils.logStopWatch(stopWatch);

    }
}
