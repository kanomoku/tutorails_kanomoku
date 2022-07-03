package array;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayBasic {

    /**
     * int值转换为字节数组
     * 缓冲区(Buffer)就是在内存中预留指定大小的存储空间用来对输入/输出(I/O)的数据作临时存储、这部分预留的内存空间就叫做缓冲区
     */
    @Test public void intToByteArray() {

        byte[] bytes = ByteBuffer
            // 从堆空间中分配缓冲区4个字节
            .allocate(4)
            //向ByteBuffer写数据
            .putInt(100).array();

        // Stream.of(bytes).forEach(a -> System.out.format("0x%x ", a)); 报错
        for (byte t : bytes) {
            System.out.format("0x%x ", t);
        }

    }

    @Test public void arrayToString() {
        String[] s1 = {"wyy", "wzz", "wxx", "wxx"};

        System.out.println(s1);

        System.out.println(s1.toString());

        System.out.println(Arrays.toString(s1));

        System.out.println(ArrayUtils.toString(s1));

        String j = StringUtils.join(s1, ", ");
        System.out.println(j);
    }

    /**
     * 初始化数组
     */
    @Test public void arrayInitialization() {
        // Initialization 1
        String[] s1 = new String[4];
        Arrays.fill(s1, "wyy");
        System.out.println(Arrays.toString(s1));

        // Initialization 2
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};
        System.out.println(Arrays.toString(s2));

        // Initialization 3
        String[] s3 = new String[] {"zyy", "zxx", "zww"};
        System.out.println(Arrays.toString(s3));

        // Initialization 4
        String[] s4 = s3.clone();
        System.out.println(Arrays.toString(s4));

        // Initialization 5
        String[] s5 = ArrayUtils.clone(s3);
        System.out.println(Arrays.toString(s5));
    }

    /**
     * 数组转List
     * <p>
     * Arrays.asList()和new ArrayList()区别：
     * Arrays.asList()和new ArrayList()返回的List的都继承了AbstractList<E>
     * 但new ArrayList<>对某些方法做了重写、支持 add(),remove()操作
     * 而Arrays.asList(st1)只做了继承，没有重写、不支持 add(),remove()操作，只支持遍历读操作;
     * <p>
     * List.of()和Arrays.asList()区别：
     * https://blog.csdn.net/qq_42520962/article/details/109380430
     * 1、Arrays.asList()可以包含/contains null，而List.of()不可以包含/contains null (NullPointerException)
     * 2、List.of生成的List不能修改，Arrays.asList生成的List能修改；如ls1.set(0,5);
     * 3、关于数组修改对List的影响。数组修改对Arrays.asList生成的List有影响，对List.of 生成的List无影响
     */
    @Test public void arrayToList() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};

        List<String> list2 = Arrays.asList(s2);
        System.out.println(list2);

        List<String> list3 = List.of(s2);
        System.out.println(list3);

        List<String> list = new ArrayList<>(List.of(s2));
        System.out.println(list);

        List<String> list4 = new ArrayList<>(Arrays.asList(s2));
        System.out.println(list4);
    }

    @Test public void ListToArray() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArray));

        String[] stringArr = new String[arrayList.size()];
        arrayList.toArray(stringArr);

        for (String s : stringArr) {
            System.out.print(s + " ");
        }
    }

    /**
     * HashMap和HashSet判断重复都是执行对象的hashcode和equals方法
     * 如果遇到重复值HashMap会用新值替换旧值（使用put方法会返回旧值），而HashSet的旧值不会被覆盖（遇到重复值会返回false）
     * 通俗的说，Map会覆盖，Set会拒绝
     */
    @Test public void arrayToSet() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};

        Set<String> set = new HashSet<>(Arrays.asList(s2));
        System.out.print(set);
    }

    @Test public void arrayLoop() {
        int[] s5 = new int[] {7, 3, 2, 8, 9};

        for (Integer s : s5) {
            System.out.print(s + " ");
        }

        System.out.println();

        for (int i = 0; i < s5.length; i++) {
            System.out.print(s5[i] + " ");
        }
    }

    @Test public void removeElement() {
        int[] intArray = {1, 2, 3, 4, 5, 3};
        int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
        System.out.println(Arrays.toString(removed));
    }

    @Test public void reverse() {
        int[] intArray = {1, 2, 3, 4, 5};
        ArrayUtils.reverse(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    @Test public void addAll() {
        int[] intArray = {1, 2, 3, 4, 5};
        int[] intArray2 = {6, 7, 8, 9, 10};
        // Apache Commons Lang library
        int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);
        System.out.println(Arrays.toString(combinedIntArray));
    }

    @Test public void contains() {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);

        boolean a = ArrayUtils.contains(stringArray, "a");
        System.out.println(a);
    }

    @Test public void streamPrac() {
        Double[] doubleArr = {1D, 2D, 3D, 11D, 22D, 33D, 111D, 222D, 333D};
        Arrays.stream(doubleArr).filter(a -> a > 2D).forEach(aDouble -> System.out.print(aDouble + " 、"));
        System.out.println();
        Arrays.stream(doubleArr, 0, 4).filter(a -> a > 2D).forEach(aDouble -> System.out.print(aDouble + " 、"));
    }

    @Test public void spliteratorPrac() {
        Double[] doubleArr = {11D, 22D, 33D, 1D, 2D, 3D, 111D, 222D, 333D};
        Arrays.sort(doubleArr);
        Arrays.stream(doubleArr).forEach(aDouble -> System.out.print(aDouble + " 、"));

        System.out.println();
        Integer[] intArr = {11, 22, 33, 1, 2, 3, 111, 222, 333};
        Arrays.sort(intArr);
        Arrays.stream(intArr).forEach(aDouble -> System.out.print(aDouble + " 、"));
    }

    @Test public void setAllParc() {
        double[] a = {1.0, 2.0, 3.0, 4.4};
        Arrays.setAll(a, x -> a[x] * a[x]);
        System.out.println("数组中整数的平方：" + Arrays.toString(a));
    }

    @Test public void mismatchPrac() {
        int[] array1 = {2, 7, 11, 22, 37};
        int[] array2 = {2, 7, 11, 22, 37};
        int[] array3 = {2, 7, 19, 31, 39, 56};

        int index1 = Arrays.mismatch(array1, array2);
        System.out.println(index1);

        int index2 = Arrays.mismatch(array1, array3);
        System.out.println(index2);
    }

    @Test public void mismatchPrac2() {
        int[] array1 = {1, 1, 1, 2, 7, 11, 22, 37};
        int[] array2 = {1, 1, 1, 2, 7, 11, 22, 37};
        int[] array3 = {1, 1, 1, 2, 7, 19, 22, 39, 56};

        int index1 = Arrays.mismatch(array1, 2, 5, array2, 2, 5);
        System.out.println(index1);

        int index2 = Arrays.mismatch(array1, 2, 5, array3, 2, 5);
        System.out.println(index2);

        int index3 = Arrays.mismatch(array1, 2, 6, array2, 2, 6);
        System.out.println(index3);

        int index4 = Arrays.mismatch(array1, 2, 6, array3, 2, 6);
        System.out.println(index4);
    }

    @Test public void hashCodePrac() {
        int[] array1 = {1, 1, 1, 2, 7, 11, 22, 37};
        int[] array2 = {1, 1, 1, 2, 7, 11, 22, 37};
        int i = Arrays.hashCode(array1);
        int j = Arrays.hashCode(array2);
        System.out.println(i);
        System.out.println(j);
    }

    @Test public void equalsPrac() {
        Integer[] array1 = {1, 1, 1, 2, 7, 11, 22, 37};
        Integer[] array2 = {1, 1, 1, 2, 7, 11, 22, 37};

        boolean equals = Arrays.equals(array1, array2);
        System.out.println(equals);

        boolean equals1 = Arrays.equals(array1, 2, 4, array2, 2, 4);
        System.out.println(equals1);

        boolean equals3 = Arrays.equals(array1, array2, new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return (o1 < o2 ? -1 : (o1.equals(o2) ? 0 : 1));
            }
        });
        System.out.println(equals3);

        boolean equals4 = Arrays.equals(array1, array2, (o1, o2) -> (o1 < o2 ? -1 : (o1.equals(o2) ? 0 : 1)));
        System.out.println(equals4);
    }

    @Test public void copyOfPrac() {
        Integer[] array1 = {1, 1, 1, 2, 7, 11, 22, 37};
        Integer[] integers = Arrays.copyOf(array1, 4);
        System.out.println(Arrays.toString(integers));

        String[] s1 = {"wyy", "wzz", "wxx", "wxx"};
        String[] strArr = Arrays.copyOf(s1, 4);
        System.out.println(Arrays.toString(strArr));
    }

    @Test public void copyOfRangePrac() {
        Integer[] array1 = {1, 1, 1, 2, 7, 11, 22, 37};
        Integer[] integers = Arrays.copyOfRange(array1, 1, 4);
        System.out.println(Arrays.toString(integers));

        String[] s1 = {"wyy", "wzz", "wxx", "wxx"};
        String[] strArr = Arrays.copyOfRange(s1, 1, 4);
        System.out.println(Arrays.toString(strArr));
    }

    @Test public void binarySearchPrac() {
        Integer[] array1 = {1, 1, 1, 2, 7, 11, 22, 37};
        int i = Arrays.binarySearch(array1, 2);
        System.out.println(i);
    }

    @Test public void comparePrac() {
        Integer[] array1 = {1, 1, 1, 2, 7, 3};
        Integer[] array2 = {1, 1, 1, 2, 7, 12};
        int compare = Arrays.compare(array1, array2);
        System.out.println(compare);
    }

    @Test public void compareUnsignedPrac() {
        int[] array1 = {1, 1, 1, 2, 7, -14};
        int[] array2 = {1, 1, 1, 2, 7, -12};
        int compare = Arrays.compareUnsigned(array1, array2);
        System.out.println(compare);
    }
}
