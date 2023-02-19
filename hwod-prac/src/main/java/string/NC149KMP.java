package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * NC149文本串 S 在 文本串 T 中出现了多少次（kmp:可以理解为常说的关键字搜索）
 */
public class NC149KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String S = bf.readLine(); // 计算模板串S
        String T = bf.readLine(); // 文本串T
        bf.close();

        int kmp = kmp1(S, T);
        System.out.println(kmp);
    }

    /**
     * NC149文本串 patternStr 在 文本串 mainStr 中出现了多少次（kmp）
     * 自己写的性能不行
     */
    public static int kmp1(String patternStr, String mainStr) {
        //特殊情况判断
        if (patternStr.length() > mainStr.length() || mainStr.length() == 0) {
            return 0;
        }

        int cnt = 0;

        int length = patternStr.length();
        for (int i = 0; i <= mainStr.length() - length; i++) {

            String substring = mainStr.substring(i, i + length);
            if (substring.equals(patternStr)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int kmp(String S, String T) {
        return easyKMP(S, T);
    }

    /**
     * NC149文本串 patternStr 在 文本串 mainStr 中出现了多少次（kmp）
     * 朴素模式匹配
     */
    public int easyKMP(String patternStr, String mainStr) {
        int patternStrLen = patternStr.length();
        int mainStrLen = mainStr.length();

        //特殊情况判断
        if (patternStrLen > mainStrLen || mainStrLen == 0) {
            return 0;
        }

        int cnt = 0; //出现次数

        //分别遍历主串和模式串
        int j = 0;
        for (int i = 0; i < mainStrLen; i++) {
//        for (int i = 0, j = 0; i < mainStrLen; i++) {

            while (j > 0 && mainStr.charAt(i) != patternStr.charAt(j)) { //只要不相等，模式串回退到0位置
                i = i - j + 1;
                j = 0;
            }

            if (mainStr.charAt(i) == patternStr.charAt(j)) {
                j++;
            }


            if (j == patternStrLen) { //如果j等于patternStrLen，说明所有字符都匹配上了
                cnt++; //次数加一，同时i回退到上次匹配开头的下一位，j回到0
                i = i - j + 2;
                j = 0;
            }
        }

        return cnt;
    }

    /**
     * NC149文本串 patternStr 在 文本串 mainStr 中出现了多少次（kmp）
     * kmp模式匹配
     */
    public static int kmpKMP(String patternStr, String mainStr) {
        int patternStrLen = patternStr.length();
        int mainStrLen = mainStr.length();

        //特殊情况判断
        if (patternStrLen > mainStrLen || mainStrLen == 0) {
            return 0;
        }

        //初始化计数，获取next数组
        int cnt = 0;
        int[] next = getNext(patternStr);

        //遍历主串和模式串
        for (int i = 0, j = 0; i < mainStrLen; i++) {
            //只要不相等，回退到next数组记录的下一位
            while (j > 0 && mainStr.charAt(i) != patternStr.charAt(j)) {
                j = next[j - 1];
            }
            if (mainStr.charAt(i) == patternStr.charAt(j)) j++;
            //如果j为m，说明完全匹配一次
            if (j == patternStrLen) {
                //计数加一，索引回退到next数组记录的下一位
                cnt++;
                j = next[j - 1];
            }
        }
        return cnt;
    }

    //确定next数组
    private static int[] getNext(String patternStr) {
        int templateLength = patternStr.length();
        int[] next = new int[templateLength];

        int j = 0;
//        for (int i = 1, j = 0; i < templateLength; i++) {
        for (int i = 1; i < templateLength; i++) {
            //只要不相等，回退到next数组记录的下一位
            while (j > 0 && patternStr.charAt(i) != patternStr.charAt(j)) {
                j = next[j - 1];
            }

            //前缀索引后移
            if (patternStr.charAt(i) == patternStr.charAt(j)) {
                j++;
            }

            //确定应该回退到的下一个索引
            next[i] = j;
        }
        return next;
    }
}
