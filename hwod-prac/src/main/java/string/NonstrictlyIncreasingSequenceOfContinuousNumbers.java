package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 非严格递增连续数字序列
 * abc2234019a334bc
 */
public class NonstrictlyIncreasingSequenceOfContinuousNumbers {
    public static void main(String[] args) throws IOException {
        // 构造数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        bf.close();

        // 结果收集容器
        int max = 0;

        // 最长连续数字序列 和 最长非严格递增连续数字序列 由此来区别
        Deque<Integer> temp;
        for (int i = 0; i < str.length(); ) {
            temp = new LinkedList<>(); // 注意要清空

            if (Character.isDigit(str.charAt(i))) {
                int start = i; // 记录其实位置
                i = i + 1; // 当前字符判断完，跳到下个字符的下标
                // 范围内，是数字，第一个数字时或非严格递增序列时
                while (i < str.length() && Character.isDigit(str.charAt(i)) && (temp.isEmpty() || temp.getLast() <= Character.getNumericValue(str.charAt(i)))) {
                    temp.addLast(Character.getNumericValue(str.charAt(i))); // 主要为了记录最后一个字符
                    i = i + 1; // 当前字符判断完，跳到下个字符的下标
                }
                int length = str.substring(start, i).length(); // 获取当前符合条件的子串

                max = Math.max(max, length); // 动态取最优值
            } else {
                i = i + 1; // 当前字符非数字时，跳到下个字符的下标
            }
        }

        // 输出结果
        System.out.println(max);
    }
}
