package com.zhangziwa.practisesvr.excuter.summation;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

    // 用传统for循环的迭代版本执行起来应该会快很多，因为它更为底层，更重要的是不需要对原始类型做任何装箱或拆箱操作。
    public static long sequentialIterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long iterateSequentialReduceSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    // iterate生成的是装箱的对象，必须拆箱成数字才能求和；
    // 我们很难把iterate分成多个独立块来并行执行。
    public static long iterateParallelReduceSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    // 这个数值流比前面那个用iterate工厂方法生成数字的顺序执行版本要快得多，因为数值流避免了非针对性流那些没必要的自动装箱和拆箱操作。
    public static long rangedSequentialReduceSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    // LongStream.rangeClosed直接产生原始类型的long数字，没有装箱拆箱的开销。
    // LongStream.rangeClosed会生成数字范围，很容易拆分为独立的小块。例如，范围1～20可分为1～5、6～10、11～15和16～20。
    public static long rangedParallelReduceSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long sequentialAccumulatorSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    // 记错错误,死刑
    // 错用并行流而产生错误的首要原因，就是使用的算法改变了某些共享状态。
    public static long parallelAccumulatorSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    // 共享累加器
    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
