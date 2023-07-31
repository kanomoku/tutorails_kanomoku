package order;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListOrder {
    @Test
    public void order() {
        List<Integer> list223 = Arrays.asList(1, 3, 7, 2, 4, 5);
        System.out.println("排序前：" + list223); // [1, 3, 7, 2, 4, 5]

        list223.sort(Comparator.naturalOrder()); // [1, 2, 3, 4, 5, 7]
        System.out.println("排序后：" + list223);
    }

    @Test
    public void reverseOrder() {
        List<Integer> list223 = Arrays.asList(1, 3, 7, 2, 4, 5);
        System.out.println("降序前：" + list223);

        list223.sort(Comparator.reverseOrder()); // [7, 5, 4, 3, 2, 1]
        System.out.println("降序后：" + list223);
    }
}
