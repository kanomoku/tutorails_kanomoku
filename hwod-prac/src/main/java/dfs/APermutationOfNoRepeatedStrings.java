package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.07. 无重复字符串的排列组合
 */
public class APermutationOfNoRepeatedStrings {
    public static void main(String[] args) {
        String[] res = permutation("qqe");
        String s = Arrays.toString(res);
        System.out.println(s);
    }

    public static String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];

        List<String> res = new ArrayList<>();
        dfs(S, new StringBuffer(), visited, res);

        return res.toArray(String[]::new);
    }

    public static void dfs(String str, StringBuffer sb, boolean[] isVisited, List<String> res) {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }
        // 无重复字符串不会有相同字符,所以不会有如下场景:[qqe, qeq, qqe, qeq, eqq, eqq]
        for (int i = 0; i < str.length(); i++) {
            if (!isVisited[i]) {
                sb.append(str.charAt(i));
                isVisited[i] = true;

                dfs(str, sb, isVisited, res);

                sb.deleteCharAt(sb.length() - 1);
                isVisited[i] = false;
            }
        }
    }
}
