package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 整数对最小和
 */
//  3 1 1 2
//  3 1 2 3
//  2
public class MinimumSumOfIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> collect1 = Arrays.stream(bf.readLine().split(" ")).toList();
        List<String> collect2 = Arrays.stream(bf.readLine().split(" ")).toList();
        int count = Integer.parseInt(bf.readLine());
        bf.close();

        // 收集数据源
        List<Integer> list1 = collect1.stream().skip(1).limit(Integer.parseInt(collect1.get(0))).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = collect2.stream().skip(1).limit(Integer.parseInt(collect2.get(0))).map(Integer::parseInt).collect(Collectors.toList());

        // 构造结果收集容器
        List<Integer> res = new ArrayList<>();

        // 逻辑处理
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                int i1 = list1.get(i) + list2.get(j);
                res.add(i1);
            }
        }

        res.sort(Comparator.naturalOrder());

        // 输出结果
        int sum = res.stream().limit(count).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
