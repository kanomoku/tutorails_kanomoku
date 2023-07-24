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

    /**
     * 条件取反
     */
    @Test
    public void negate() {
        Predicate<Integer> predicate = t -> t > 4;
        System.out.println(predicate.negate().test(5)); // false
        System.out.println(predicate.negate().test(4)); // true
        System.out.println(predicate.negate().test(3)); // true

        System.out.println(Predicate.not(predicate).test(5)); // false
        System.out.println(Predicate.not(predicate).test(4)); // true
        System.out.println(Predicate.not(predicate).test(3)); // true
    }

    @Test
    public void and() {
        Predicate<Integer> predicate = t -> t > 4;
        Predicate<Integer> predicate2 = t -> t < 6;

        System.out.println(predicate.and(predicate2).test(3)); // false
        System.out.println(predicate.and(predicate2).test(5)); // true
        System.out.println(predicate.and(predicate2).test(7)); // false
    }

    @Test
    public void or() {
        Predicate<Integer> predicate = t -> t >= 6;
        Predicate<Integer> predicate2 = t -> t <= 4;

        System.out.println(predicate.or(predicate2).test(4)); // true
        System.out.println(predicate.or(predicate2).test(5)); // false
        System.out.println(predicate.or(predicate2).test(6)); // true
    }
}