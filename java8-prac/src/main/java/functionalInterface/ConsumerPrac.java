package functionalInterface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerPrac {

    @Test
    public void basic() {
        // 1、传统方式
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer);

        // 2、lambda表达式
        Consumer<String> consumer1 = (s) -> System.out.print(s);
        Stream<String> stream1 = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream1.forEach(consumer1);

        stream1.forEach((s) -> System.out.print(s));

        // 3、语法糖
        Stream<String> stream2 = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream2.forEach(System.out::print);
    }

    @Test
    public void andThen() {
        StringBuilder sb = new StringBuilder("Hello ");

        Consumer<StringBuilder> consumer = (str) -> str.append("Jack!");
        consumer.accept(sb);
        System.out.println(sb.toString());    // Hello Jack!

        Consumer<StringBuilder> consumer1 = (str) -> str.append(" Bob!");
        consumer.andThen(consumer1).accept(sb);
        System.out.println(sb.toString());    // Hello Jack! Bob!
    }
}

