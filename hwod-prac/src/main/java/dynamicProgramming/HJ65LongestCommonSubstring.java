package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * HJ65 查找两个字符串a,b中的最长公共子串
 */
public class HJ65LongestCommonSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        bf.close();

        String longestCommonSubstring = getLongestCommonSubstring(str1, str2);
        System.out.println(longestCommonSubstring);

    }

    // 动态规划
    public static String getLongestCommonSubstring1(String str1, String str2) {
        String shortWords;
        String longWords;
        // 保证str1是较短字符串
        if (str1.length() > str2.length()) {
            shortWords = str2;
            longWords = str1;
        } else {
            shortWords = str1;
            longWords = str2;
        }

        int shortLen = shortWords.length() + 1;
        int longLen = longWords.length() + 1;

        // 表示在较短字符串str1以第i个字符结尾，str2中以第j个字符结尾时的公共子串长度。
        int[][] dp = new int[shortLen][longLen];

        // 匹配字符，并记录最大值的str1的结尾下标
        int max = 0;
        int index = 0;

        // 从左向右递推，i为短字符串str1的结尾索引，j为str2的结尾索引
        for (int i = 1; i < shortLen; i++) {
            for (int j = 1; j < longLen; j++) {
                if (shortWords.charAt(i - 1) == longWords.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 相等则计数
                    if (dp[i][j] > max) { // 不断更新变量
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }

        // 截取最大公共子串
        return shortWords.substring(index - max, index);
    }

    /**
     * HJ65 查找两个字符串a,b中的最长公共子串
     */
    public static String getLongestCommonSubstring(String s1, String s2) {
        String shortStr = s1.length() < s2.length() ? s1 : s2;
        String longStr = s1.length() > s2.length() ? s1 : s2;

        int maxLen = 0;
        int start = 0;

        for (int left = 0; left < shortStr.length(); left++) {
            if (shortStr.length() - left + 1 <= maxLen) { // 剪枝，子串长度已经不超过maxLen没必要计算，退出循环（性能优化）
                break;
            }

            for (int right = shortStr.length(); right > left; right--) { // 左指针i，右指针right, 右指针逐渐向左逼近
                String subStr = shortStr.substring(left, right);
                if (longStr.contains(subStr) && maxLen < subStr.length()) {
                    maxLen = subStr.length();
                    start = left;
                    break;
                }
            }
        }

        return shortStr.substring(start, start + maxLen);
    }

}
