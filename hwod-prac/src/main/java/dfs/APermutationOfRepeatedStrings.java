package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APermutationOfRepeatedStrings {
    public static void main(String[] args) {

        String[] res = permutation("qqe");
        String s = Arrays.toString(res);
        System.out.println(s);

    }

    public static String[] permutation(String S) {

        char[] arr = S.toCharArray();
        Arrays.sort(arr);

        // 标记是否走过
        boolean[] visited = new boolean[arr.length];

        // 收集结果
        List<String> res = new ArrayList<>();
        dfs(arr, new StringBuilder(), visited, res);

        // 输出指定格式
        return res.toArray(String[]::new);
    }

    /**
     * @param arr     素材字符串
     * @param sb
     * @param visited 标记是否走过
     * @param res     收集结果
     */
    public static void dfs(char[] arr, StringBuilder sb, boolean[] visited, List<String> res) {

        if (sb.length() == arr.length) { // 字符串拼接到和数组一样长的时候就停止收集了
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {  // 当前字符没有走过

                // 第一项以后,两个字符相等时的场景
                // 理解arr[i] == arr[i - 1] && book[i - 1]和arr[i] == arr[i - 1] && !book[i - 1]的区别
                if (0 < i && arr[i] == arr[i - 1] && !visited[i - 1]) {
                    continue;
                } else {
                    // 递归下去
                    sb.append(arr[i]); // 收集此字符
                    visited[i] = true; // 标记被走过

                    dfs(arr, sb, visited, res);

                    // 回溯上来
                    visited[i] = false; // 当前字符里全处理完毕，故去除标记
                    sb.deleteCharAt(sb.length() - 1); // 挪掉最后一个字符才有拼接下个字符的机会
                }
            }
        }
    }
}
