package com.zhangziwa.practisesvr.excuter.productpricesearch.v1;


import com.zhangziwa.practisesvr.utils.thread.DelayUtils;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.zhangziwa.practisesvr.utils.thread.DelayUtils.getMoment;

@Data
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    // 依据指定产品名称返回价格,同步方法
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    // 依据指定产品名称返回价格,将同步方法转换为异步方法
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price); // 如果价格计算正常结束，完成Future操作并设置商品价格
        }).start();

        return futurePrice;
    }

    private double calculatePrice(String product) {
        DelayUtils.delay();
        System.out.println(getMoment() + " " + Thread.currentThread().getName() + " 线程执行 calculatePrice");
        // 依据产品的名称，生成一个随机值作为价格
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
