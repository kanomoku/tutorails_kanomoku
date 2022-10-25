package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HJ3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(bf.readLine()));
        }
        bf.close();


        // Set 升序排序
        List<Integer> collect = nums.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
