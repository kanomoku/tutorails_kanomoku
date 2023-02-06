package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 【LeetCode】77. 组合
 */
public class Combination {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int n1 = parseInt(bf.readLine());
        int k1 = parseInt(bf.readLine());
        bf.close();

        int n = 5; // n个数，1,2,3,4,5
        int k = 3; // 任意三个的组合
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 每组k个数,k<=0时没意义;n<k时没意义，一共n个想取k个不合理
        if (k <= 0 || n < k) {
            return res;
        }

        // 临时变量
        Deque<Integer> path = new LinkedList<>();

        dfs(n, k, 1, path, res);

        // 返回结果
        return res;
    }

    public static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) { // 一共收集k层,已经收集到k层时直接收工大退
            res.add(new ArrayList<>(path));
            return;
        }

        // 这是一个横展开
        for (int i = begin; i <= n; i++) {
            // 递归下去
            path.push(i);
            dfs(n, k, i + 1, path, res);
            // 回溯上来
            path.pop();
        }
    }
}
