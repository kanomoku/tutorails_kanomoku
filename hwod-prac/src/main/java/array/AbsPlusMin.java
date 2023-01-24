package array;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// -1 -3 7 5 11 15
public class AbsPlusMin {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        bf.close();

        // String → int[]
        int[] ints = Arrays.stream(str.split(" ")).filter(StringUtils::isNotBlank).mapToInt(Integer::parseInt).toArray();

        // 业务要求的结果
        int min = Integer.MAX_VALUE;
        int[] temp = new int[2];

        for (int i = 0; i < ints.length; i++) {
            // 排除自己和自己计算
            for (int j = 0; j < ints.length && i != j; j++) {
                int i1 = Math.abs(ints[i] + ints[j]);
                if (i1 < min) {
                    min = i1;
                    temp[0] = ints[i];
                    temp[1] = ints[j];
                }
            }
        }

        // 排序
        Arrays.sort(temp);

        // 输出结果
        String collect = Arrays.stream(temp).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect + " " + min);
    }
}
