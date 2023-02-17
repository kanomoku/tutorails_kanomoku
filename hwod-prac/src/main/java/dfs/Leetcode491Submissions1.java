package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

/**
 * leetcode491 找出整数数组中不同的递增子序列
 */
public class Leetcode491Submissions1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        int[] s = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> subsequences = findSubsequences(s);
        System.out.println(subsequences);
    }


    public static List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        dfs(0, Integer.MIN_VALUE, nums, queue, res);

        return res;
    }

    /**
     * 不好理解回头消化
     */
    private static void dfs(int index, int preValue, int[] arr, Deque<Integer> queue, List<List<Integer>> res) {
        if (index >= arr.length) {  // 遍历结束
            if (queue.size() >= 2) {
                res.add(new ArrayList<>(queue));
            }
            return;
        }

        if (arr[index] >= preValue) {   // 将当前元素加入，并向后遍历
            queue.addLast(arr[index]);
            dfs(index + 1, arr[index], arr, queue, res);
            queue.removeLast();
        }
        if (arr[index] != preValue) {   // 不遍历 重复元素
            dfs(index + 1, preValue, arr, queue, res);  // 将下一个元素加入，并向后遍历
        }
    }
}

