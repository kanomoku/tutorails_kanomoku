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
 * 滑动窗口最大和
 * 1 3 -1 -3 5 3 6 7
 * 3
 */
public class SlideWindowMaximumSum_Array {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = Integer.parseInt(bf.readLine());
        bf.close();

        // 收集结果容器
        List<Integer> res = new ArrayList<>();

        // 业务逻辑处理
        for (int i = 0; i <= s.length - size; i++) {
            int[] ints = Arrays.copyOfRange(s, i, i + size);
            Arrays.stream(ints).max().ifPresent(res::add);
        }

        res.sort(Comparator.naturalOrder());

        // 输出结果
        String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
