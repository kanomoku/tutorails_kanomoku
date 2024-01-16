package com.zhangziwa.practisesvr.excuter.productpricesearch.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.zhangziwa.practisesvr.utils.thread.DelayUtils.getMoment;

public class AsyncShopClient {

    public static void main(String[] args) {
        AsyncShop shop = new AsyncShop("BestShop");

        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " 调用方法获取价格");
        Future<Double> futurePrice = shop.getPrice4("myPhone");

        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " 查询调用结果futurePrice.get()");
        try {
            System.out.println(getMoment() + " " + "Price is " + futurePrice.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}