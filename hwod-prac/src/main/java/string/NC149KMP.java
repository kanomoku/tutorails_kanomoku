package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * NC149 kmp算法
 */
public class NC149KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String S = bf.readLine(); // 计算模板串S
        String T = bf.readLine(); // 文本串T
        bf.close();

        int kmp = kmp(S, T);
        System.out.println(kmp);
    }

    /**
     * 自己写的性能不行
     */
    public static int kmp1(String S, String T) {
        if (S.length() > T.length() || S.length() == 0) {
            return 0;
        }
        int res = 0;
        int length = S.length(); // length
        for (int i = 0; i <= T.length() - length; i++) {

            String substring = T.substring(i, i + length);
            if (substring.equals(S)) {
                res++;
            }
        }
        return res;
    }

    public static int kmp(String S, String T) {
        //特殊情况判断
        int m = S.length();
        int n = T.length();
        if (m > n || n == 0) {
            return 0;
        }

        //初始化计数，获取next数组
        int count = 0;
        int[] next = getNext(S);

        //遍历主串和模式串
        for (int i = 0, j = 0; i < n; i++) {
            //只要不相等，回退到next数组记录的下一位
            while (j > 0 && T.charAt(i) != S.charAt(j)) {
                j = next[j - 1];
            }
            if (T.charAt(i) == S.charAt(j)) j++;
            //如果j为m，说明完全匹配一次
            if (j == m) {
                //计数加一，索引回退到next数组记录的下一位
                count++;
                j = next[j - 1];
            }
        }
        return count;
    }

    //确定next数组
    private static int[] getNext(String template) {
        int templateLength = template.length();
        int[] next = new int[templateLength];
        for (int i = 1, j = 0; i < templateLength; i++) {
            //只要不相等，回退到next数组记录的下一位
            while (j > 0 && template.charAt(i) != template.charAt(j)) {
                j = next[j - 1];
            }
            //前缀索引后移
            if (template.charAt(i) == template.charAt(j)) j++;
            //确定应该回退到的下一个索引
            next[i] = j;
        }
        return next;
    }
}
