package com.zhangziwa.practisesvr.excuter.productpricesearch.v4;

import com.zhangziwa.practisesvr.excuter.productpricesearch.v1.Shop;
import com.zhangziwa.practisesvr.excuter.productpricesearch.v4.ExchangeService.Money;
import com.zhangziwa.practisesvr.excuter.threadfactory.ExecuterThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll")                                                 ,
                                                   new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), ExecuterThreadFactoryBuilder.build());

    // 为了更直观地感受一下使用CompletableFuture在代码可读性上带来的巨大提升，尝试仅使用Java 7中提供的特性实现以下如上实现
    public List<String> findPricesInUSDJava7(String product) {
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            final Future<Double> futureRate = executor.submit(new Callable<Double>() {
                public Double call() {
                    return ExchangeService.getRate(Money.EUR, Money.USD);
                }
            });

            Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() {
                public Double call() {
                    try {
                        double priceInEUR = shop.getPrice(product);
                        return priceInEUR * futureRate.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
            });

            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = new ArrayList<>();
        for (Future<Double> priceFuture : priceFutures) {
            try {
                prices.add(" price is " + priceFuture.get());
            }
            catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    public List<String> findPricesInUSD(String product) {
        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            CompletableFuture<Double> futurePriceInUSD = CompletableFuture
                    .supplyAsync(() -> shop.getPrice(product), executor)
                    .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD), executor), (price, rate) -> price * rate);
            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .map(price -> " price is " + price)
                .collect(Collectors.toList());

        return prices;
    }

    public List<String> findPricesInUSD2(String product) {
        List<CompletableFuture<String>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            CompletableFuture<String> futurePriceInUSD = CompletableFuture
                            .supplyAsync(() -> shop.getPrice(product), executor)
                            .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD), executor), (price, rate) -> price * rate)
                            .thenApply(price -> shop.getName() + " price is " + price);
            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPricesInUSD3(String product) {
        List<CompletableFuture<String>> priceFutures = shops
            .stream()
            .map(shop -> CompletableFuture
                .supplyAsync(() -> shop.getPrice(product))
                .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)), (price, rate) -> price * rate)
                .thenApply(price -> shop.getName() + " price is " + price))
            .collect(Collectors.toList());

        List<String> prices = priceFutures
            .stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPricesInUSD4(String product) {
        List<CompletableFuture<String>> priceFutures = shops
                .stream()
                .map(shop -> CompletableFuture
                        .supplyAsync(() -> shop.getPrice(product),executor)
                        .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD),executor), (price, rate) -> price * rate)
                        .thenApply(price -> shop.getName() + " price is " + price))
                .collect(Collectors.toList());

        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

}
