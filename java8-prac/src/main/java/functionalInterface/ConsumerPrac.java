package functionalInterface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerPrac {

    @Test
    public void test(){

        //1
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer);

        //2
        Consumer<String> consumer1 = (s) -> System.out.print(s);
        Stream<String> stream1 = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream1.forEach(consumer1);

        //3
        Stream<String> stream2 = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream2.forEach(System.out::print);
    }
}

