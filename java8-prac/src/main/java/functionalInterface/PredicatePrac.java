package functionalInterface;

import org.junit.Test;

import java.util.function.Predicate;

public class PredicatePrac {
    @Test
    public void basic() {
        // 1、传统方式
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        };
        System.out.println(predicate.test(1));

        // 2、lambda表达式
        Predicate<Integer> predicate1 = t -> t > 5;
        System.out.println(predicate1.test(1));
    }

    @Test
    public void equals() {
        Predicate<Integer> equalPredicate = Predicate.isEqual(3);
        System.out.println(equalPredicate.test(5)); // false
        System.out.println(equalPredicate.test(4)); // false
        System.out.println(equalPredicate.test(3)); // true
    }
}