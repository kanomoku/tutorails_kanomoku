package javabasic.thread.exp.exp2.v2;

import javabasic.thread.exp.exp2.v1.Shop;
import javabasic.thread.threadfactory.ExecuterThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll")                                                 ,
                                                   new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), ExecuterThreadFactoryBuilder.build());

    // 采用顺序查询所有商店的方式
    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    // 使用并行流对请求进行并行操作
    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    // 使用CompletableFuture发起异步请求
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + shop.getName() + "-" + shop.getPrice(product)))// 内部采用的通用线程池，默认都使用固定数目的线程，具体线程数取决于Runtime.getRuntime().availableProcessors()的返回值。
                        .collect(Collectors.toList());

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join) // 对List中的所有future对象执行join操作，一个接一个地等待它们运行结束
                .collect(Collectors.toList());
        return prices;
    }

    // 使用CompletableFuture发起异步请求+使用定制的执行器
    public List<String> findPricesFutureCustom(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + shop.getName() + "-" + shop.getPrice(product), executor))
                        .collect(Collectors.toList());

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        return prices;
    }
}
