package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class SharingTheApples {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        Integer num = parseInt(bf.readLine());
        Integer[] apples = Arrays.stream(bf.readLine().split(" ")).limit(num).map(Integer::parseInt).toArray(Integer[]::new);

        bf.close();

        int res = 0;
        for (int i = 0; i < apples.length; i++) {
            // 不进位的加法就是亦或操作
            res = res ^ apples[i];
        }
        if (res != 0) {
            System.out.println(-1);
        }

        // 降序
        Arrays.sort(apples, Comparator.reverseOrder());
        // 根据亦或运算法则第6条
        int sum = Arrays.stream(apples).limit(num - 1).mapToInt(Integer::intValue).sum();

        // 输出结果
        System.out.println(sum);
    }
}
