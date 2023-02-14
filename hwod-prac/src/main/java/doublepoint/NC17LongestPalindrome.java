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

    public static int getLongestPalindrome(String A) {
        int maxLen = 0;
        int n = A.length();
        //暴力解法
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String now = A.substring(i, j);//确定字符
                if (isPalindrome(now) && now.length() > maxLen) {
                    maxLen = now.length();//最大长度
                }
            }
        }
        return maxLen;
    }

    /**
     * 判断子串是不是回文子串
     */
    public static boolean isPalindrome(String s) {
        // abcba  奇数时 5/2=2 范围for (int i = 0; i < 2; i++) [0 1] 2 3 4
        // abccba 偶数时 6/2=3 范围for (int i = 0; i < 3; i++) [0 1 2] 3 4 5
        int strLength = s.length();
        for (int i = 0; i < strLength / 2; i++) {
            // 数组折叠对应下标相加为strLength - 1
            if (s.charAt(i) != s.charAt(strLength - 1 - i))//不相等
                return false;
        }
        return true;
    }
}
