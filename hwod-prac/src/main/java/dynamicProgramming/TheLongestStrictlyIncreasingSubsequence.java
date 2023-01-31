package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class TheLongestStrictlyIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bf.close();

        // 结果收集器
        int max = 0;

        // 动态规划
        // 参数初始化
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            // 通过回放计算出dp[i]的最优值
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    // 状态转移方程
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                }
            }
            // dp[i]的最优值和max相比计算出max的最优值
            max = Math.max(dp[i], max);
        }

        // 输出结果
        System.out.println(max);
    }
}
