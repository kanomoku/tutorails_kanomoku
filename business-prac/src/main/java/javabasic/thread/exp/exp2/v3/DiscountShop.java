package javabasic.thread.exp.exp2.v3;


import javabasic.thread.exp.exp2.util.Util;
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

    // 根据产品名称返回价格折扣信息
    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double calculatePrice(String product) {
        Util.delay();
        // 依据产品的名称，生成一个随机值作为价格
        return Util.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}
