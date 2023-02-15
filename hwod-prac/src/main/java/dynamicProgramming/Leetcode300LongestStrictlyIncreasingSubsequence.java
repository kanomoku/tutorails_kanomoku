package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

/**
 * leetcode  300. 整数数组的最长严格递增子序列的长度
 */
public class Leetcode300LongestStrictlyIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bf.close();

        int max = lengthOfLIS(arr);

        // 输出结果
        System.out.println(max);
    }

    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 参数初始化
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1; // 每个序列起码有自己所以长度最小为1
        }

        int max = 1; // 每个序列起码有自己所以长度最小为1

        for (int i = 1; i < nums.length; i++) {
            // 通过回放计算出dp[i]的最优值
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 状态转移方程
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            // dp[i]的最优值和max相比计算出max的最优值
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
