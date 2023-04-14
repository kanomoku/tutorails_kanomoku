package functionalInterface;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierPrac {
    @Test public void basic() {
        // 1、传统方式
        Supplier<Double> supplier = new Supplier<Double>() {
            @Override public Double get() {
                // 返回一个随机值
                return new Random().nextDouble();
            }
        };
        System.out.println(supplier.get());

        // 2、lambda表达式
        supplier = () -> new Random().nextDouble();
        System.out.println(supplier.get());

        // 3、语法糖
        supplier = Math::random;
        System.out.println(supplier.get());
    }
}
