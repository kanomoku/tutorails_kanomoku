package com.zhangziwa.practisesvr.excuter.productpricesearch.v3;

import com.zhangziwa.practisesvr.excuter.threadfactory.ExecuterThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.zhangziwa.practisesvr.utils.DelayUtils.getMoment;
import static com.zhangziwa.practisesvr.utils.StopWatchUtils.postFillSpace;

public class BestPriceFinder {

    private final List<DiscountShop> discountShops = Arrays.asList(new DiscountShop("BestPrice"),
                                                   new DiscountShop("LetsSaveBig"),
                                                   new DiscountShop("MyFavoriteShop"),
                                                   new DiscountShop("BuyItAll"),
                                                   new DiscountShop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(discountShops.size(), ExecuterThreadFactoryBuilder.build());

    // 串行支持
    public List<String> findPricesSequential(String product) {
        return discountShops.stream()
                .map(discountShop -> discountShop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    // 并行流的方式
    // Stream底层依赖的是线程数量固定的通用线程池
    public List<String> findPricesParallel(String product) {
        return discountShops.parallelStream()
                .map(discountShop -> discountShop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    // 构造同步和异步操作+返回值
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                discountShops.stream()
                        .map(discountShop -> CompletableFuture.supplyAsync(() -> discountShop.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))// 一般情况下解析操作不涉及任何远程服务，也不会进行任何I/O操作，它几乎可以在第一时间进行，所以能够采用同步操作，不会带来太多的延迟。
                        .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                        .collect(Collectors.<CompletableFuture<String>>toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)// 等待流中的所有Future执行完毕，并提取各自的返回值
                .collect(Collectors.toList());
    }

    // 构造同步和异步操作+消费型
    public List<String> printPricesStream(String product) {
        long start = System.nanoTime();

        CompletableFuture<String>[] priceFutures = discountShops.stream()
                .map(discountShop -> CompletableFuture.supplyAsync(() -> discountShop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .peek(f -> f.thenAccept(s -> System.out.println(postFillSpace(s) + getMoment() + " " + Thread.currentThread().getName() + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);

        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " All shops finished in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");

        CompletableFuture.allOf(priceFutures).join();
        return null; // 仅为了统一使用stopwatch加的返回值
    }
}
