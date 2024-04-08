package com.zhangziwa.practisesvr.excuter.productpricesearch.v2;


import lombok.Data;

import java.util.Random;

@Data
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
