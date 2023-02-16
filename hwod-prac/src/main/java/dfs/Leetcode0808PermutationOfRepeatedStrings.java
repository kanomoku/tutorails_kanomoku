package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 */
public class Leetcode0808PermutationOfRepeatedStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        String[] res = permutation("qqe");

        System.out.println(Arrays.toString(res));
    }

    public static String[] permutation(String S) {
        char[] arr = S.toCharArray();
        // 排序之后，相同字符位于字符数组中的相邻位置，可以利用这一特点去重
        Arrays.sort(arr);

        // 标记是否走过
        boolean[] visited = new boolean[S.length()];

        // 收集结果
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(new String(arr), sb, visited, res);

        // 输出指定格式
        return res.toArray(String[]::new);
    }

    /**
     * @param str     素材字符串
     * @param sb      拼接字符串的临时变量
     * @param visited 标记是否走过
     * @param res     收集结果
     */
    public static void dfs(String str, StringBuilder sb, boolean[] visited, List<String> res) {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // 去重时排除自己
            // 已经加入当前排列，则不能多次加入当前排列
            if (visited[i]) {
                continue;
            }

            // 确保arr[i−1]在arr[i]前加入排列
            // arr[i−1]未加入当前排列,则不能将arr[i]加入当前排列,否则arr[i−1]将在arr[i]之后加入当前排列,导致出现重复排列
            if (0 < i && str.charAt(i) == str.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }

            // 递归下去
            sb.append(str.charAt(i));
            visited[i] = true;
            dfs(str, sb, visited, res);
            // 回溯上来
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
