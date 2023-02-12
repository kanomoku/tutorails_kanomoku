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
        List<Integer> collect = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> collect1 = Arrays.stream(bf.readLine().split(" ")).collect(Collectors.toList());
        bf.close();

        Integer total = collect.get(0);
        Integer limit = collect.get(1);
        List<Integer> collect2 = collect1.stream().limit(total).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> collect3 = collect2.stream().sorted(Comparator.naturalOrder()).limit(limit).collect(Collectors.toList());
        String collect4 = collect3.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect4);
    }
}
