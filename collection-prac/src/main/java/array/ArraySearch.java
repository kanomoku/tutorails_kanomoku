package array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArraySearch {
    @Test public void Test_Array_Search() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};
        boolean a = arrayIncludeValueCheck_LoopSearch(s2, "wyy");
        boolean b = arrayIncludeValueCheck_LoopSearch(s2, "wy");
        boolean c = arrayIncludeValueCheck_binarySearch(s2, "wyy");
        boolean d = arrayIncludeValueCheck_binarySearch(s2, "wy");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static boolean arrayIncludeValueCheck_LoopSearch(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分法查找先查找数组中间的元素、如果找到就返回数组中该元素的下标、如果没找到就返回(-插入点-1)
     * 比如  int[] a = {1,3,5,7,8,9}; int b = 10; 返回的是-7:（插入点下标为6，返回-6-1 就是-7）
     * 比如  int[] a = {1,3,5,7,8,9}; int b = 5; 返回的是2
     */
    public static boolean arrayIncludeValueCheck_binarySearch(String[] arr, String targetValue) {

        int j = Arrays.binarySearch(arr, targetValue);
        if (j >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
