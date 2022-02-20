package array;

import org.testng.annotations.Test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayBasic {

    /**
     * int值转换为字节数组
     * 缓冲区(Buffer)就是在内存中预留指定大小的存储空间用来对输入/输出(I/O)的数据作临时存储、这部分预留的内存空间就叫做缓冲区
     */
    @Test
    public void intToByteArray() {

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

    /**
     * 初始化数组
     */
	@Test
    public void arrayInitialization() {
		// Initialization 1
		String[] s1 = new String[4];
		Arrays.fill(s1, "wyy");

		for (String s : s1) {
			System.out.println(s);
		}
		System.out.println(s1.toString());
		System.out.println(Arrays.toString(s1));

		// Initialization 2
		String[] s2 = {"wyy", "wzz", "wxx", "wxx"};
		System.out.println(Arrays.toString(s2));
        
		// Initialization 3
		String[] s3 = new String[] {"zyy", "zxx", "zww"};
		System.out.println(Arrays.toString(s3));
	}

    /**
     * 数组转List
     *
     * Arrays.asList()和new ArrayList()区别：
     * Arrays.asList()和new ArrayList()返回的List的都继承了AbstractList<E>
     * 但new ArrayList<>对某些方法做了重写、支持 add(),remove()操作
     * 而Arrays.asList(st1)只做了继承，没有重写、不支持 add(),remove()操作，只支持遍历读操作;
     * 
     * List.of()和Arrays.asList()区：
     * https://blog.csdn.net/qq_42520962/article/details/109380430
     * 1、Arrays.asList()可以包含/contains null，而List.of()不可以包含/contains null (NullPointerException)
     * 2、List.of生成的List不能修改，Arrays.asList生成的List能修改；如ls1.set(0,5);
     * 3、关于数组修改对List的影响。数组修改对Arrays.asList生成的List有影响，对List.of 生成的List无影响
     */
    @Test
    public void arrayToList() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};

        List<String> list = new ArrayList<>(List.of(s2));
        list.add("aa");
        System.out.println(list);
        List<String> list2 = Arrays.asList(s2);
        System.out.println(list2);
        List<String> list3 = List.of(s2);
        System.out.println(list3);
    }

    /**
     * HashMap和HashSet判断重复都是执行对象的hashcode和equals方法
     * 如果遇到重复值HashMap会用新值替换旧值（使用put方法会返回旧值），而HashSet的旧值不会被覆盖（遇到重复值会返回false）
     * 通俗的说，Map会覆盖，Set会拒绝
     */
    @Test
    public void arrayToSet() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};

        Set<String> set = new HashSet<>(Arrays.asList(s2));
        System.out.print(set);
    }

    @Test
    public void arrayLoop() {
        int[] s5 = new int[] {7, 3, 2, 8, 9};

        for (Integer s : s5) {
            System.out.print(s);
        }

        System.out.println();

        for (int i = 0; i < s5.length; i++) {
            System.out.print(s5[i]);
        }
    }
}
