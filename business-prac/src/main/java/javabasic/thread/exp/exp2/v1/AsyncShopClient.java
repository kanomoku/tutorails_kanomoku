package javabasic.thread.exp.exp2.v1;

import javabasic.thread.exp.exp2.v1.AsyncShop;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncShopClient {

    public static void main(String[] args) {
        AsyncShop shop = new AsyncShop("BestShop");

        System.out.println(Thread.currentThread().getName() + " 调用getPrice");
        Future<Double> futurePrice = shop.getPrice("myPhone");

        System.out.println(Thread.currentThread().getName() + " 查询结果futurePrice.get()");
        try {
            System.out.println("Price is " + futurePrice.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}