package array;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;

public class ArrayUtilsPrac {
    @Test public void addPrac() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        System.out.println(Arrays.toString(stringArray));
        String[] fs = ArrayUtils.add(stringArray, "f");
        System.out.println(Arrays.toString(fs));
    }

    @Test public void addAllPrac() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        String[] stringArray2 = {"a", "b", "c", "d", "e"};
        String[] fs = ArrayUtils.addAll(stringArray, stringArray2);
        System.out.println(Arrays.toString(fs));
    }

    @Test public void addFirstPrac() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        String[] fs = ArrayUtils.addFirst(stringArray, "t");
        System.out.println(Arrays.toString(fs));
    }

    @Test public void clonePrac() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        String[] fs = ArrayUtils.clone(stringArray);
        System.out.println(Arrays.toString(fs));
    }

    @Test public void containsPrac() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        boolean a = ArrayUtils.contains(stringArray, "a");
        System.out.println(a);
    }

    @Test public void indexesOfPrac() {
        String[] stringArray = {"a", "a", "b", "c", "d", "a"};
        BitSet a = ArrayUtils.indexesOf(stringArray, "a");
        System.out.println(a);
        BitSet b = ArrayUtils.indexesOf(stringArray, "a", 1);
        System.out.println(b);

        double[] arr = {1D, 2D, 3D, 4D, 5D, 2D};
        BitSet d = ArrayUtils.indexesOf(arr, 3D, 1);
        System.out.println(d);
        BitSet d1 = ArrayUtils.indexesOf(arr, 3D, 2);
        System.out.println(d1);
        BitSet d2 = ArrayUtils.indexesOf(arr, 3D, 3);
        System.out.println(d2);

        BitSet c = ArrayUtils.indexesOf(arr, 3D, 1D);
        System.out.println(c);

        BitSet e = ArrayUtils.indexesOf(arr, 2D);
        System.out.println(e);

        BitSet f = ArrayUtils.indexesOf(arr, 3D, 2, 1D);
        System.out.println(f);
    }

    @Test public void indexOfPrac() {
        String[] stringArray = {"a", "a", "b", "c", "d", "a"};
        int a = ArrayUtils.indexOf(stringArray, "a");
        System.out.println(a);

        int b = ArrayUtils.indexOf(stringArray, "a", 1);
        System.out.println(b);
    }

    @Test public void insertPrac() {
        String[] stringArray = {"a", "a", "b", "c", "d", "a"};
        String[] zs = ArrayUtils.insert(1, stringArray, "z", "s");
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(zs));
    }

    @Test public void isArrayIndexValidPrac() {
        String[] stringArray = {"a", "a"};
        boolean arrayIndexValid = ArrayUtils.isArrayIndexValid(stringArray, 2);
        System.out.println(arrayIndexValid);
    }

    @Test public void emptyPrac() {
        String[] stringArray = {"a", "a"};
        boolean a = ArrayUtils.isEmpty(stringArray);
        boolean b = ArrayUtils.isNotEmpty(stringArray);
        System.out.println(a);
        System.out.println(b);
    }

    @Test public void isSortedPrac() {
        String[] stringArray = {"a", "a"};
        boolean a = ArrayUtils.isSorted(stringArray);
        System.out.println(a);
        String[] arr = {"a", "b"};
        boolean b = ArrayUtils.isSorted(arr);
        System.out.println(b);
        String[] arr1 = {"a", "b", "a"};
        boolean c = ArrayUtils.isSorted(arr1);
        System.out.println(c);
    }

    @Test public void shiftPrac() {

        String[] stringArray1 = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(stringArray1, 1);
        System.out.println(Arrays.toString(stringArray1));

        String[] stringArray = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(stringArray, 2);
        System.out.println(Arrays.toString(stringArray));

        String[] stringArray2 = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(stringArray2, 3);
        System.out.println(Arrays.toString(stringArray2));

        String[] stringArray3 = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(stringArray3, 4);
        System.out.println(Arrays.toString(stringArray3));

        String[] stringArray4 = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(stringArray4, 5);
        System.out.println(Arrays.toString(stringArray4));

        String[] stringArray5 = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(stringArray5, 6);// 6%5 ->1 取模
        System.out.println(Arrays.toString(stringArray5));

        String[] arr1 = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(arr1, 1, 3, 1);
        System.out.println(Arrays.toString(arr1));

        String[] arr = {"a", "b", "c", "d", "e"};
        ArrayUtils.shift(arr, 1, 3, 2);
        System.out.println(Arrays.toString(arr));
    }

    @Test public void subArrayPrac() {
        String[] stringArray1 = {"a", "b", "c", "d", "e"};
        String[] subarray = ArrayUtils.subarray(stringArray1, 1, 3);
        System.out.println(Arrays.toString(subarray));
    }

    @Test public void swapPrac() {
        String[] stringArray1 = {"a", "b", "c", "d", "e"};
        ArrayUtils.swap(stringArray1, 1, 3);
        System.out.println(Arrays.toString(stringArray1));

        String[] stringArray2 = {"a", "b", "c", "d", "e"};
        ArrayUtils.swap(stringArray2, 1, 3, 1);
        System.out.println(Arrays.toString(stringArray2));
    }

    @Test public void toArrayPrac() {
        String[] strings = ArrayUtils.toArray("a", "b", "c", "d", "e");
        System.out.println(Arrays.toString(strings));
    }

    @Test public void toMapPrac() {
        Map colorMap = ArrayUtils.toMap(new String[][] {{"RED", "#FF0000"}, {"GREEN", "#00FF00"}, {"BLUE", "#0000FF"}});
        System.out.println(colorMap);
    }

    @Test public void toStringPrac() {
        String[] strings = ArrayUtils.toArray("a", "b", "c", "d", "e");
        System.out.println(Arrays.toString(strings));
        System.out.println(ArrayUtils.toString(strings));
    }
}
