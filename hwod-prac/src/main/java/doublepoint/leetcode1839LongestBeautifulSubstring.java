package doublepoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 1839. 所有元音按顺序排布的最长子字符串
 */
public class leetcode1839LongestBeautifulSubstring {

    public int longestBeautifulSubstring(String word) {
        Map<Character, Integer> valueMap = new HashMap();
        valueMap.put('a', 0);
        valueMap.put('e', 1);
        valueMap.put('i', 2);
        valueMap.put('o', 3);
        valueMap.put('u', 4);

        char[] chars = word.toCharArray();
        int start = 0;

        int res = 0;
        int length = word.length();
        for (int i = 0; i < length - 1; ) {
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
}
