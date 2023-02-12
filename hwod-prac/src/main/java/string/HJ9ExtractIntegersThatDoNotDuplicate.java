package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * HJ9 提取不重复的整数
 */
public class HJ9ExtractIntegersThatDoNotDuplicate {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<Character> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!list.contains(chars[i]))
                list.add(chars[i]);
        }

        String res = list.stream().map(String::valueOf).collect(Collectors.joining(""));
        System.out.println(res);
    }
}
