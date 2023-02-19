package odexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Third {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 第一行数量
        int numCount = Integer.parseInt(bf.readLine());
        // 第二行分配随机数
        long[] nums = Arrays.stream(bf.readLine().split(" ")).limit(numCount).mapToLong(Long::parseLong).toArray();
        bf.close();

        List<Long> res = new ArrayList<>();
        boolean isFind;
        for (int i = 0; i < nums.length; i++) { // 遍历每个人
            isFind = false;
            // 遇到贵人
            for (int j = i + 1; j < nums.length; j++) {  // 计算第i个人的奖金
                if (nums[i] < nums[j]) { // 遇到第一个比自己大的人
                    int distance = j - i; // 计算距离
                    Long overCount = nums[j] - nums[i]; // 多的数
                    Long money = distance * overCount; //  距离*数字
                    res.add(money);
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                res.add(nums[i]); // 没遇到贵人,收到自己抽到的奖金
            }
        }
        String collect = res.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
