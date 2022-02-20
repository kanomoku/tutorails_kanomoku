import org.testng.annotations.Test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class ArrayBasic {

    /**
     * int值转换为字节数组
     * 缓冲区(Buffer)就是在内存中预留指定大小的存储空间用来对输入/输出(I/O)的数据作临时存储、这部分预留的内存空间就叫做缓冲区
     */
    @Test
    public void intToByteArray() {

        int intNum = 100;
        byte[] bytes = ByteBuffer
            // 从堆空间中分配缓冲区4个字节
            .allocate(4)
            //向ByteBuffer写数据
            .putInt(intNum).array();

        // Stream.of(bytes).forEach(a -> out.format("0x%x ", a)); 报错
        for (byte t : bytes) {
            out.format("0x%x ", t);
        }

    }

	@Test
    public void arrayInitialization() {
		// Initialization 1
		String[] s1 = new String[4];
		Arrays.fill(s1, "wyy");

		for (String s : s1) {
			out.println(s);
		}
		out.println(s1.toString());
		out.println(Arrays.toString(s1));

		// Initialization 2
		String[] s2 = {"wyy", "wzz", "wxx", "wxx"};
		out.println(s2.toString());
		out.println(Arrays.toString(s2));

		// Initialization 3
		String[] s3 = new String[] {"zyy", "zxx", "zww"};
		out.println(s3.toString());
		out.println(Arrays.toString(s3));
	}

    /**
     * Arrays.asList()和 new ArrayList()返回的List的都继承了AbstractList<E>
     * 但new ArrayList<>对某些方法做了重写，
     * 而Arrays.asList(st1)只做了继承，没有重写、不支持 add(),remove()操作，只支持遍历读操作;
     */
    @Test
    public void arrayToList() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};

        List<String> list = new ArrayList<>(Arrays.asList(s2));
        out.print(list.toString());
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
        out.print(set.toString());
    }

    @Test
    public void arrayLoop() {
        int[] s5 = new int[] {7, 3, 2, 8, 9};

        for (Integer s : s5) {
            out.print(s);
        }

        out.println();

        for (int i = 0; i < s5.length; i++) {
            out.print(s5[i]);
        }
    }
}
