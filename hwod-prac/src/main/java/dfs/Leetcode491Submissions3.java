package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * leetcode491 找出整数数组中不同的递增子序列
 */
public class Leetcode491Submissions3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        int[] s = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> subsequences = findSubsequences(s);
        System.out.println(subsequences);
    }


    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }

        Deque<Integer> queue = new LinkedList<>();
        dfs(0, nums, queue, res);

        return res.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 递归枚举子序列的通用模板
     */
    public static void dfs(int start, int[] nums, Deque<Integer> queue, List<List<Integer>> res) {
        if (queue.size() >= 2) { // 满足条件就快照一下
            res.add(new ArrayList<>(queue));
        }

        for (int i = start; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.getLast() > nums[i]) {
                // 不满足递增子序列(两整数相等视作递增)条件时，继续处理下一下
                continue;
            }

            queue.addLast(nums[i]);
            dfs(i + 1, nums, queue, res);
            queue.removeLast();
        }
    }
}