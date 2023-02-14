package doublepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * NC28 最小覆盖子串
 */
public class NC28MinimumWindowSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String S = bf.readLine();
        String T = bf.readLine();
        bf.close();

        String s = minWindow(S, T);
        System.out.println(s);
    }

    /**
     * 在 s 中找出最短的包含 t 中所有字符的连续子串
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public static String minWindow(String S, String T) {
        int sLength = S.length() + 1;

        //记录目标字符串T的字符个数
        int[] hash = new int[128];
        for (int i = 0; i < T.length(); i++) {
            //初始化哈希表都为负数，找的时候再加为正
            // -=1是应对重复字符变为-2，-3这种的时候
            hash[T.charAt(i)] -= 1;
        }

        //记录左右区间
        int left = -1;
        int right = -1;

        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            char aChar = S.charAt(i);
            //目标字符匹配+1
            hash[aChar]++;

            //没有小于0的说明都覆盖了，缩小窗口
            while (allGE0(hash)) {
                //取最优解
                if (sLength > i - start + 1) {
                    sLength = i - start + 1;
                    left = start;
                    right = i;
                }
                aChar = S.charAt(start);
                //缩小窗口的时候减1
                hash[aChar]--;
                //窗口缩小
                start++;
            }
        }

        //找不到的情况
        if (left == -1) {
            return "";
        }

        return S.substring(left, right + 1);
    }

    /**
     * 检查是否都>=0
     */
    static boolean allGE0(int[] hash) {
        for (int j : hash) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }
}
