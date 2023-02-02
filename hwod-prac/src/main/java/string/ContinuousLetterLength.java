package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 连续字母长度
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

        // 结果收集容器
        Map<Character, Integer> map = new HashMap<>();
        // 中间变量
        Deque<Character> chars;

        for (int i = 0; i < str.length(); ) {
            chars = new LinkedList<>();
            while (i < str.length() && (chars.isEmpty() || chars.contains(str.charAt(i)))) { // ((有效范围内&&(第一字符时||还是这个字符时))收集此字符
                chars.addLast(str.charAt(i));
                i = i + 1; // 当前字符处理完毕，跳到下个字符坐标
            }

            Integer tempMax = map.getOrDefault(chars.getFirst(), 0); // 取出当前字符已知的最大长度
            map.put(chars.getFirst(), Math.max(tempMax, chars.size())); // 动态算取最大长度
        }

        // 输出结果
        map.values().stream().sorted(Comparator.reverseOrder()).skip(k - 1).limit(1).forEach(System.out::println);
    }
}
