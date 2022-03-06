package functionalInterface;

import org.junit.Test;

import java.util.function.Predicate;

public class PredicatePrac {
    @Test public void test() {
        //1
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        };
        System.out.println(predicate.test(1));

        //2
        predicate = (t) -> t > 5;
        System.out.println(predicate.test(1));
    }
}
