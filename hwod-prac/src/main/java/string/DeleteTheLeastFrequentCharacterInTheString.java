package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class DeleteTheLeastFrequentCharacterInTheString {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();
        char[] chars = str.toCharArray();

        // 统计每个字符的个数
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char aChar : chars) {
            Integer orDefault = tempMap.getOrDefault(aChar, 0);
            tempMap.put(aChar, ++orDefault);
        }

        // 取最小值
        int min = tempMap.values().stream().mapToInt(Integer::intValue).min().getAsInt();

        // 收集最小值的所有字符
        List<Character> collect = tempMap.entrySet().stream().filter(a -> a.getValue() == min).map(Map.Entry::getKey).collect(Collectors.toList());

        // 方式1：拼接新字符串
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (collect.contains(aChar)) {
                continue;
            }
            sb.append(aChar);
        }
        System.out.println(sb);

        // 方式2：
        for (int i = 0; i < collect.size(); i++) {
            str = str.replaceAll(String.valueOf(collect.get(i)), "");
        }

        // 输出结果
        System.out.println(str);
    }
}
