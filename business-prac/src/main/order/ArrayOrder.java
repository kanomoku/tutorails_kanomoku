package order;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayOrder {
    @Test
    public void order() {
        // 升序
        int[] size = {1, 3, 7, 2, 4, 5};
        System.out.println("排序前：" + Arrays.toString(size));
        Arrays.sort(size);
        System.out.println("排序后：" + Arrays.toString(size));

        Integer[] size1 = {1, 3, 7, 2, 4, 5};
        System.out.println("排序前：" + Arrays.toString(size1));
        Arrays.sort(size1, Comparator.naturalOrder()); //必须Integer
        System.out.println("排序后：" + Arrays.toString(size1));


        char[] chars = "bca".toCharArray();
        Arrays.sort(chars); // [a, b, c]
        System.out.println(Arrays.toString(chars));

        String[] strs = {"abc","abe","abd","bc"};
        Arrays.sort(strs); // [abc, abd, abe, bc]
        System.out.println(Arrays.toString(strs));


    }


    @Test
    public void reverseOrder() {
        // 降序
        Integer[] size1 = {1, 3, 7, 2, 4, 5};
        System.out.println("排序前：" + Arrays.toString(size1));
        Arrays.sort(size1, Comparator.reverseOrder()); //必须Integer [7, 5, 4, 3, 2, 1]
        System.out.println("排序后：" + Arrays.toString(size1));

        char[] chars = "bca".toCharArray();
        // Arrays.sort(chars, Comparator.reverseOrder()); // 编译不过

        String[] strs = {"abc","abe","abd","bc"};
        Arrays.sort(strs, Comparator.reverseOrder()); // [bc, abe, abd, abc]
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void customOrder() {
        // 二维数组 存储书本的长和宽
        // [长,宽] → 先长度降序,再宽度降序
        int[][] books = {{1, 2}, {4, 5}, {3, 7}, {3, 4}};
        System.out.println("排序前：");
        Arrays.stream(books).forEach(a -> System.out.println(Arrays.toString(a)));

        Arrays.sort(books, (book1, book2) -> {
            if (book1[0] == book2[0]) { // 长度相等,按宽降序
                return book2[1] - book1[1];
            } else {
                return book2[0] - book1[0]; // 优先按照长度降序
            }
        });

        System.out.println("排序后：");
        Arrays.stream(books).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    @Test
    public void reverse() {
        List<Integer> list223 = Arrays.asList(1, 3, 7, 2, 4, 5);
        Collections.reverse(list223);  //[5, 4, 2, 7, 3, 1]
        System.out.println("位置颠倒后：" + list223);
    }
}
