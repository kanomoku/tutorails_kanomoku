package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class StackingOfBooks {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int counts = parseInt(bf.readLine()); // 几本书
        int[][] books = new int[counts][2]; // 收集书的容器
        for (int i = 0; i < counts; i++) {
            int[] book = Arrays.stream(bf.readLine().split(" ")).limit(2).mapToInt(Integer::parseInt).toArray(); // 每本书的长宽信息
            books[i] = book;
        }
        bf.close();

        // 需要排好序为了动态规划做准备
        Arrays.sort(books, (a, b) -> {
            if (a[0] == b[0]) { // 长相等快降序
                return b[1] - a[1];
            } else {
                return b[0] - a[0]; // 长降序
            }
        });

        // 收集结果
        int max = 0;

        // 参数初始化
        int[] dp = new int[counts];
        for (int i = 0; i < counts; i++) {
            dp[i] = 1; // 每一摞书都有自己所有初始值为1
        }

        for (int i = 1; i < counts; i++) {
            // 通过回放计算出dp[i]的最优值
            for (int j = 0; j < i; j++) {
                if (books[i][0] <= books[j][0] && books[i][1] <= books[j][1]) { // 长和宽小于等于下面的书就表示可以摞上来
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
