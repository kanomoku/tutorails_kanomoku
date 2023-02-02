package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 求字符串中所有整数的最小和
 * bb1234aa
 * bb12-34aa
 * bb12-34aa+11-11
 */
public class FindTheMinimumSumOfAllTheIntegersInTheString {
    public static void main(String[] args) throws IOException {
        // 读取数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        bf.close();

        // 结果收集容器
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < str.length(); ) {
            if (Character.isDigit(str.charAt(i))) {
                res.add(Character.getNumericValue(str.charAt(i))); // 数字直接收集，坐标跳到下一位
                i = i + 1;
            } else if ('-' == str.charAt(i)) {
                // 遇到负号开始拼接最大负数
                int start = i; // 记录开始位置
                i = i + 1; // 跳过当前负号的位置，到下一坐标
                while (i < str.length() && Character.isDigit(str.charAt(i))) { // 如果下一位在范围内，且是数字，继续蚕食
                    i = i + 1;
                }
                // i为下一个位置的坐标，也就可以视为当前子串的右边界
                res.add(Integer.parseInt(str.substring(start, i)));
            } else {
                i = i + 1; // 非数字，非负号，皆跳过
            }
        }

        // 输出结果
        int sum = res.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }
}
