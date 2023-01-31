package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 高效的任务规划
 * 2
 * 3
 * 1 3
 * 2 4
 * 3 6
 * 3
 * 1 3
 * 2 4
 * 3 6
 */
public class EfficientTaskPlanning {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res = new ArrayList<>();

        // 处理m组数据
        int m = Integer.parseInt(bf.readLine());
        for (int j = 0; j < m; j++) {
            // 收集1组机器的n台机器
            int n = Integer.parseInt(bf.readLine());
            int[][] machines = new int[n][2];
            for (int i = 0; i < n; i++) {
                int[] machine = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                machines[i] = machine;
            }

            // 算每组数据的最短用时
            int minTime = minTime(n, machines);
            res.add(minTime);
        }
        bf.close();
        String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    private static int minTime(int n, int[][] machines) {
        // 运行时间降序，运行时间相同则补数时间升序
        Arrays.sort(machines, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        // 中间变量
        int total = 0; // 总用时
        int deploy = 0; // 部署所必须花费的时间

        // 参数初始化
        int[] dp = new int[n]; // 动态规划、执行完当前机器用时累计、因为不能同时部署2台机器所以可以使用动态规划

        for (int i = 0; i < n; i++) {
            // 状态转移方程
            dp[i] = deploy + machines[i][0] + machines[i][1]; // 执行完当前机器用时累计
            total = Math.max(dp[i], total); // 当前机器用时、已知累计时间最久的时间相比，取运行时间长的
            deploy += machines[i][0]; // 收集当前机器部署完成所用的时间，为下台机器用时统计做准备
        }
        return total;
    }
}
