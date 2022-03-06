package functionalInterface;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionPrac {
    @Test
    public void test(){
        // 1
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbbbb", "ccccccv");
        Stream<Integer> stream1 = stream.map(function);
        stream1.forEach(System.out::println);

        // 2
        Function<String, Integer> function1 = (s)-> s.length();
        Stream.of("aaa", "bbbbb", "ccccccv").map(function1).forEach(System.out::println);
    }
}
