package doublepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * leetcode1839. 所有元音按顺序排布的最长子字符串
 */
public class leetcode1839LongestBeautifulSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        int i = longestBeautifulSubstring1(str);

    }

    /**
     * leetcode1839. 所有元音按顺序排布的最长子字符串
     * 参考的题解
     */
    public static int longestBeautifulSubstring1(String word) {
        Map<Character, Integer> valueMap = new HashMap();
        valueMap.put('a', 0);
        valueMap.put('e', 1);
        valueMap.put('i', 2);
        valueMap.put('o', 3);
        valueMap.put('u', 4);

        char[] chars = word.toCharArray();

        int res = 0;

        int start = 0;
        for (int i = 0; i < word.length() - 1; ) {
            i++;
            if (chars[start] == 'a' && (valueMap.get(chars[i - 1]) + 1 == valueMap.get(chars[i]) || valueMap.get(chars[i - 1]) == valueMap.get(chars[i]))) {
                if (chars[start] == 'a' && chars[i] == 'u') {
                    res = Math.max(i - start + 1, res);
                }
            } else {
                start = i;
            }
        }
        return res;
    }

    /**
     * leetcode1839. 所有元音按顺序排布的最长子字符串
     * 参考的题解→适合自己的题解
     */
    public static int longestBeautifulSubstring(String word) {
        Map<Character, Integer> valueMap = new HashMap();
        valueMap.put('a', 0);
        valueMap.put('e', 1);
        valueMap.put('i', 2);
        valueMap.put('o', 3);
        valueMap.put('u', 4);

        char[] chars = word.toCharArray();

        int res = 0;

        int start = 0;
        for (int i = 1; i < word.length(); i++) {
            // 'a'开始'u'结束且已保证递增，故可以保证（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次
            // 按照 字典序 升序排布
            if (chars[start] == 'a' && (valueMap.get(chars[i - 1]) + 1 == valueMap.get(chars[i]) || valueMap.get(chars[i - 1]) == valueMap.get(chars[i]))) {
                if (chars[i] == 'u') {
                    res = Math.max(i - start + 1, res);
                }
            } else {
                start = i;
            }
        }
        return res;
    }
}
