package doublepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * NC17 最长回文子串
 */
public class NC17LongestPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        int longestPalindrome = getLongestPalindrome(str);
        System.out.println(longestPalindrome);
    }

    /**
     * NC17 最长回文子串
     */
    public static int getLongestPalindrome(String A) {
        int max = 0;

        int len = A.length();
        //暴力解法
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String subStr = A.substring(i, j);//确定字符
                if (isPalindrome(subStr) && subStr.length() > max) {
                    max = subStr.length();//最大长度
                }
            }
        }

        return max;
    }

    /**
     * 判断子串是不是回文子串
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int strLength = s.length();
        for (int i = 0; i < strLength / 2; i++) {
            if (s.charAt(i) != s.charAt(strLength - 1 - i)) // 不相等
                return false;
        }

        return true;
    }
}
