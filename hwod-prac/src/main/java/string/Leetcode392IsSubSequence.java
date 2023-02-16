package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * leetcode392 判断字符串 s 是否为 t 的子序列
 * abc
 * ahbgdc
 * <p>
 * axc
 * ahbgdc
 */
public class Leetcode392IsSubSequence {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String s = bf.readLine();
        String t = bf.readLine();
        bf.close();

        boolean res = isSubsequence(s, t);

        // 输出结果
        System.out.println(res);
    }

    private static boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
                if (index >= s.length()) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 判断字符串 s 是否为 t 的子序列
     */
    private static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        char[] son = s.toCharArray();
        char[] mother = t.toCharArray();

        int index = 0;
        for (int i = 0; i < mother.length; i++) {
            if (mother[i] == son[index]) {
                if (index >= son.length - 1) { // 最后一个字符是相等的
                    return true;
                }
                index++; // 当前字符处理完指针挪到下个位置，为后续做准备
            }
        }

        return false;
    }

    /**
     * 过于讨巧了
     */
    public boolean isSubsequence1(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
