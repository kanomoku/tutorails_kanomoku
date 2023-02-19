package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 【算法题】连续字母长度
 * <p>
 * AABAAA
 * 2
 * <p>
 * AAAAHHHBBCDHHHH
 * 3
 */
public class ContinuousLetterLength {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine(); // 需要处理的字符串
        int k = parseInt(bf.readLine()); // 查看的第几个长度
        bf.close();

        Map<Character, Integer> map = getCharAndSizeMap(str);

        // 输出结果
        map.values().stream().sorted(Comparator.reverseOrder()).skip(k - 1).limit(1).forEach(System.out::println);
    }

    /**
     * [算法题]连续字母长度
     */
    private static Map<Character, Integer> getCharAndSizeMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        Deque<Character> dynamicChars;
        for (int i = 0; i < str.length(); ) {
            dynamicChars = new LinkedList<>();
            while (i < str.length() && (dynamicChars.isEmpty() || dynamicChars.contains(str.charAt(i)))) { // ((有效范围内&&(第一字符时||还是这个字符时))收集此字符
                dynamicChars.addLast(str.charAt(i));
                i = i + 1; // 当前字符处理完毕，跳到下个字符坐标
            }

            Integer tempMax = map.getOrDefault(dynamicChars.getFirst(), 0); // 取出当前字符已知的最大长度
            map.put(dynamicChars.getFirst(), Math.max(tempMax, dynamicChars.size())); // 动态算取最大长度
        }

        return map;
    }
}
