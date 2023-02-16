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
 * 面试题 08.07. 无重复字符串的排列组合
 */
public class Leetcode0807PermutationOfNoRepeatedStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        String[] res = permutation("qqe");

        System.out.println(Arrays.toString(res));
    }

    public static String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[S.length()];
        StringBuilder sb = new StringBuilder();
        dfs(S, sb, visited, res);

        return res.toArray(String[]::new);
    }

    public static void dfs(String str, StringBuilder sb, boolean[] isVisited, List<String> res) {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isVisited[i]) {
                continue;
            }
            sb.append(str.charAt(i));
            isVisited[i] = true;

            dfs(str, sb, isVisited, res);

            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
