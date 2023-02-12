package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

/**
 * HJ5.进制转换
 */
public class HJ5HexadecimalToDecimal {
    private static Map<Character, Integer> map = new HashMap<>() {{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
        put('a', 10);
        put('b', 11);
        put('c', 12);
        put('d', 13);
        put('e', 14);
        put('f', 15);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String hexStr = bf.readLine();
        bf.close();

        // 去除前面的额0x
        hexStr = hexStr.substring(2);
        char[] chars = hexStr.toCharArray();


        // 公式1
        int res = 0;
        for (char aChar : chars) {
            res = res * 16 + map.getOrDefault(aChar, 0);
        }
        System.out.println(res);

        // 公式1
        int res1 = 0;
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer orDefault = map.getOrDefault(chars[i], 0);
            res1 += orDefault * Math.pow(16, index++);
        }
        System.out.println(res1);
    }
}
