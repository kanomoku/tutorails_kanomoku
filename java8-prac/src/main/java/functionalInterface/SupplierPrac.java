package functionalInterface;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierPrac {
    @Test public void test() {
        //1
        Supplier<Double> supplier = new Supplier<Double>() {
            @Override public Double get() {
                // 返回一个随机值
                return new Random().nextDouble();
            }
        };
        System.out.println(supplier.get());

        //2
        supplier = () -> new Random().nextDouble();
        System.out.println(supplier.get());

        //3
        supplier = Math::random;
        System.out.println(supplier.get());
    }
}
