package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 */
public class HJ101Input0Or1ToOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine());
        List<Integer> collect = Arrays.stream(bf.readLine().split(" ")).limit(num).map(Integer::parseInt).collect(Collectors.toList());
        String order = bf.readLine();
        bf.close();

        List<Integer> res = collect.stream().sorted((a, b) -> {
            if ("0".equals(order)) {
                return a - b;
            } else {
                return b - a;
            }
        }).collect(Collectors.toList());

        String resStr = res.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(resStr);
    }
}
