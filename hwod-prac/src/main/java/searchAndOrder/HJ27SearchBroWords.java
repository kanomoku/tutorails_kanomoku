package searchAndOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ27 查找兄弟单词
 */
public class HJ27SearchBroWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<String> collect = Arrays.stream(str.split(" ")).collect(Collectors.toList());

        // 单词个数
        int nums = parseInt(collect.get(0));
        // 收集单词
        List<String> words = collect.stream().skip(1).limit(nums).collect(Collectors.toList());
        // 兄弟单词模板
        String target = collect.get(collect.size() - 2);
        // 需要查看的第几个
        int th = parseInt(collect.get(collect.size() - 1));

        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String str1 = words.get(i);
            boolean bro = isBro(str1, target);
            if (bro) {
                res.add(str1);
            }
        }

        System.out.println(res.size());
        String s = res.stream().sorted(Comparator.naturalOrder()).skip(th - 1).limit(1).findFirst().orElse("");
        System.out.println(s);
    }

    public static boolean isBro(String str, String target) {
        // 长度不等指定不为兄弟单词
        if (str.length() != target.length()) {
            return false;
        }

        // 兄弟单词要求和原来的单词不同
        if (str.equals(target)) {
            return false;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] targets = target.toCharArray();
        Arrays.sort(targets);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != targets[i]) {
                return false;
            }
        }
        return true;
    }
}
