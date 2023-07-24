package functionalInterface;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionPrac {
    @Test
    public void test() {
        // 1、传统方式
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        List<Integer> list = Stream.of("aaa", "bbbbb", "ccccccv").map(function).toList();
        System.out.println(list);

        // 2、lambda表达式
        Function<String, Integer> function1 = (s) -> s.length();
        List<Integer> list2 = Stream.of("aaa", "bbbbb", "ccccccv").map(function1).toList();
        System.out.println(list);
    }

    @Test
    public void compose() {
        Function<Integer, Integer> multiplyBy2 = i -> i * 2; // 扩大两倍
        Function<Integer, Integer> squared = i -> i * i; // 求平方

        System.out.println(multiplyBy2.apply(4)); // 8

        System.out.println(squared.apply(4)); // 16

        //32 先平方再乘2 → 先4×4然后16×2
        System.out.println(multiplyBy2.compose(squared).apply(4));//32

        //64 先乘2再平方 → 先4×2然后8×8
        System.out.println(multiplyBy2.andThen(squared).apply(4));//64

        Map<String, Integer> map = Stream.of("This", "is", "a", "test")
                .collect(Collectors.toMap(Function.identity(), String::length));
        // {a=1, test=4, This=4, is=2}
        System.out.println(map);
    }
}
