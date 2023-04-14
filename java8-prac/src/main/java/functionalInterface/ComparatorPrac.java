package functionalInterface;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class ComparatorPrac {
    @Test
    public void basic() {
        // 1、传统方式
        Comparator<Integer> consumer = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        List<Integer> list = List.of(1, 6, 3, 5, 6, 3, 2, 8);
        List<Integer> collect = list.stream().sorted(consumer).toList(); // [1, 2, 3, 3, 5, 6, 6, 8]
        System.out.println(collect);

        // 2、lambda表达式
        List<Integer> list1 = List.of(1, 6, 3, 5, 6, 3, 2, 8);
        List<Integer> integers = list1.stream().sorted((o1, o2) -> o2 - o1).toList(); // [8, 6, 6, 5, 3, 3, 2, 1]
        System.out.println(integers);
    }
}
