package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * HJ14 字符串排序
 */
public class HJ14StringSort {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = Integer.parseInt(bf.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(bf.readLine());
        }
        bf.close();

        // 字符串按照字典序排列
        List<String> collect = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        // 输出结果
        collect.forEach(System.out::println);
    }
}
