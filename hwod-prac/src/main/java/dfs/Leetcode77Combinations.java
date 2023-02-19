package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * LeetCode77. 组合
 * 范围 [1, n] 中所有可能的 k 个数的组合
 */
public class Leetcode77Combinations {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        bf.close();

        int n = 5; // n个数，1,2,3,4,5
        int k = 3; // 任意三个的组合
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }

    /**
     * LeetCode77. 组合
     * 范围 [1, n] 中所有可能的 k 个数的组合
     */
    public static List<List<Integer>> combine(int n, int k) {
        // k<=0时没意义;
        // n<k时没意义,一共才n个想取k个不合理
        if (k <= 0 || n < k) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        dfs(1, n, k, stack, res);

        return res;
    }

    public static void dfs(int start, int milestone, int limit, Deque<Integer> stack, List<List<Integer>> res) {
        if (stack.size() == limit) {
            res.add(new ArrayList<>(stack));
            System.out.println(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i <= milestone; i++) {
            stack.push(i);
            dfs(i + 1, milestone, limit, stack, res);
            stack.pop();
        }
    }
}
