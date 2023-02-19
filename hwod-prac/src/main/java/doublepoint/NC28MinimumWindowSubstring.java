package doublepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        // 记录目标字符串T的字符个数
        // 没有用通俗的Map统计每个字符的数量，而是用了int[]（天然的Map）
        int[] CntPerChar = new int[128];
        for (int i = 0; i < T.length(); i++) {
            CntPerChar[T.charAt(i)] += 1;
        }

        //记录左右区间
        int left = -1;
        int right = -1;

        int minLen = Integer.MAX_VALUE;

        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            CntPerChar[S.charAt(i)]--; //目标字符匹配,就消减一个字符

            while (allItemLE0(CntPerChar)) { //没有小于0的说明都覆盖了，缩小窗口
                if (i - start + 1 < minLen) { // 求最小覆盖子串，故动态收集最优值
                    minLen = i - start + 1;
                    left = start;
                    right = i;
                }

                // start因为要右移动,所以把对应位置的字符收集起来，重新取排除
                CntPerChar[S.charAt(start)]++;
                start++;
            }
        }

        if (left == -1) { //找不到的情况
            return "";
        }

        return S.substring(left, right + 1);
    }

    public static boolean allItemLE0(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否都>=0
     * <p>
     * 运行时间
     * 24ms
     * 占用内存
     * 10048KB
     */
    public static boolean allItemGE0(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否都>=0
     * <p>
     * 运行时间
     * 28ms
     * 占用内存
     * 10020KB
     */
    public static boolean allItemGE2(int[] arr) {
        for (int j : arr) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否都>=0
     * 运行时间
     * 181ms
     * 占用内存
     * 16696KB
     */
    public static boolean allItemGE03(int[] arr) {
        return Arrays.stream(arr).allMatch(a -> a >= 0);
    }

    /**
     * 检查是否都>=0
     * 运行时间
     * 167ms
     * 占用内存
     * 16620KB
     */
    public static boolean allItemGE04(int[] arr) {
        return !Arrays.stream(arr).anyMatch(a -> a < 0);
    }

    /**
     * 检查是否都>=0
     * 运行时间
     * 186ms
     * 占用内存
     * 16504KB
     */
    public static boolean allItemGE05(int[] arr) {
        return Arrays.stream(arr).noneMatch(a -> a < 0);
    }
}
