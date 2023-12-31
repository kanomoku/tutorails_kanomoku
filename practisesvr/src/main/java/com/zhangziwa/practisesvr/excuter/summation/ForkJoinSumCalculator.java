package com.zhangziwa.practisesvr.excuter.summation;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

//继承RecursiveTask来创建可以用于分支/合并框架的任务
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    // ---------------------------框架的属性---------------------------
    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    // ---------------------------业务的属性---------------------------
    public static final long THRESHOLD = 10_000;  //不再将任务分解为子任务的数组大小
    private final long[] numbers;
    private final int start;
    private final int end;

    //公共构造函数 用于 创建主任务
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    //私有构造函数 用于 以递归方式为主任务创建子任务
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    // 调用主任务入口
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return FORK_JOIN_POOL.invoke(task);
    }

    // 感觉像主管给不同人派活,然后收集结果
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            //如果大小小于或等于阈值，顺序计算结果
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2); //为数组的前一半求和
        leftTask.fork(); // 另起一个ForkJoinPool线程 异步执行 新创建的子任务

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end); //为数组的后一半求和
        Long rightResult = rightTask.compute(); // 当前线程继续执行后半部分任务

        Long leftResult = leftTask.join(); // 等leftTask执行完毕

        return leftResult + rightResult; // 收集2个子任务结果组合
    }

    // 最底层的串行计算
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}