package com.zhangziwa.practisesvr.excuter.productpricesearch.v3;


import com.zhangziwa.practisesvr.utils.thread.DelayUtils;
import lombok.Data;

import java.util.Random;

@Data
public class DiscountShop {

    private final String name;
    private final Random random;

    public DiscountShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    // 对商品组装报价
    public String getPrice(String product) {
        // 获取价格
        double price = calculatePrice(product);
        // 获取折扣
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        // 提供报价
        return name + ":" + price + ":" + code;
    }

    // 获取商品价格
    private double calculatePrice(String product) {
        DelayUtils.delay();
        // 依据产品的名称，生成一个随机值作为价格
        return DelayUtils.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}
