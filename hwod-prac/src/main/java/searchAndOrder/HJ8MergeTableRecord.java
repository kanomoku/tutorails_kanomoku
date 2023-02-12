package searchAndOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class HJ8MergeTableRecord {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine()); // 处理个数

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Integer orDefault = map.getOrDefault(arr[0], 0);
            map.put(arr[0], orDefault + arr[1]);
        }
        bf.close();

        HashMap<Integer, Integer> res = map.entrySet().stream()
                .sorted((a, b) -> a.getKey() - b.getKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        res.entrySet().stream().map(a -> a.getKey() + " " + a.getValue()).forEach(System.out::println);
    }
}
