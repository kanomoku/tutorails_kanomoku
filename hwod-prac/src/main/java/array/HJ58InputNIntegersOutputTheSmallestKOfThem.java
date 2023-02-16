package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * HJ58 输入n个整数，输出其中最小的k个
 */
public class HJ58InputNIntegersOutputTheSmallestKOfThem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String totalLimitStr = bf.readLine();
        String numsStr = bf.readLine();
        bf.close();

        int[] totalLimit = Arrays.stream(totalLimitStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        Integer total = totalLimit[0];
        Integer limit = totalLimit[1];

        List<Integer> limitNums = getIntegers(numsStr, total, limit);

        String collect4 = limitNums.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect4);
    }

    private static List<Integer> getIntegers(String numsStr, Integer total, Integer limit) {
        List<String> numsStrs = Arrays.stream(numsStr.split(" ")).collect(Collectors.toList());
        // 收集固定个数
        List<Integer> nums = numsStrs.stream().limit(total).map(Integer::parseInt).collect(Collectors.toList());
        // 排序后，截取指定个数
        return nums.stream().sorted(Comparator.naturalOrder()).limit(limit).collect(Collectors.toList());
    }
}
