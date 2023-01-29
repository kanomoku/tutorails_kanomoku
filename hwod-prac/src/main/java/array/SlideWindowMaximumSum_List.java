package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 滑动窗口最大和
 * 1 3 -1 -3 5 3 6 7
 * 3
 */
public class SlideWindowMaximumSum_List {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> collect = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).toList();
        int size = Integer.parseInt(bf.readLine());
        bf.close();

        // 结果收集容器
        List<Integer> res = new ArrayList<>();

        // 逻辑处理
        for (int i = 0; i <= collect.size()-size; i++) {
            List<Integer> integers = collect.subList(i, i + size);
            integers.stream().mapToInt(Integer::intValue).max().ifPresent(res::add);
        }

        // 输出结果
        String str = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(str);
    }
}
