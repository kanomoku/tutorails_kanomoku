package searchAndOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ68 成绩排序
 */
public class HJ68GradeRanking {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        // 人的信息个数
        int num = parseInt(bf.readLine());
        // 升序还是降序
        int order = parseInt(bf.readLine());
        // 收集人的信息
        List<List<String>> persons = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<String> person = Arrays.stream(bf.readLine().split(" ")).collect(Collectors.toList());
            persons.add(person);
        }
        bf.close();

        // 排序
        List<List<String>> orderPersons = persons.stream().sorted((a, b) -> {
            if (order == 0) { // 降序
                return parseInt(b.get(1)) - parseInt(a.get(1));
            } else { // 升序
                return parseInt(a.get(1)) - parseInt(b.get(1));
            }
        }).collect(Collectors.toList());

        // 输出
        orderPersons.stream().map(a -> {
            return a.stream().collect(Collectors.joining(" "));
        }).forEach(System.out::println);
    }
}
