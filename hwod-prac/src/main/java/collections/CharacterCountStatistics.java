package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * HJ10 字符个数统计
 */
public class CharacterCountStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (0 <= chars[i] && chars[i] <= 127) {
                set.add(chars[i]);
            }
        }

        System.out.println(set.size());
    }
}
