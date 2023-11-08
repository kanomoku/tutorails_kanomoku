package javabasic.thread.exp.exp2.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopMain {

    public static void main(String[] args) {
        async();
//        sync();
    }

    private static void sync() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();

        double price = shop.getPrice("product name");
        System.out.println(Thread.currentThread().getName() + " Invocation returned after " + ((System.nanoTime() - start) / 1_000_000) + " msecs");

        System.out.printf(Thread.currentThread().getName() + " Price is %.2f%n", price);

        doSomethingElse();

        System.out.println(Thread.currentThread().getName() + " Price returned after " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }

    private static void async() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("product name");
        System.out.println(Thread.currentThread().getName() + " Invocation returned after " + ((System.nanoTime() - start) / 1_000_000) + " msecs");

        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.printf(Thread.currentThread().getName() + " Price is %.2f%n", price);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " Price returned after " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }


    private static void doSomethingElse() {
        System.out.println(Thread.currentThread().getName() + " Do some more tasks, like querying other shops...");
    }
}
