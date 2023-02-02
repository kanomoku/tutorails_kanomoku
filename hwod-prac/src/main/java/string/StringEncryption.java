package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 字符串ASC码+偏移量实现加密
 * <p>
 * 3
 * abcde
 * abcde
 * abcde
 */
public class StringEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        // 处理几组数据
        int num = parseInt(bf.readLine());

        // 结果收集容器
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            char[] chars = bf.readLine().toCharArray();
            String tran = tran(chars);
            lines.add(tran);
        }
        bf.close();

        // 输出结果
        lines.forEach(System.out::println);
    }

    /**
     * 递归获取位置
     */
    public static int fun(int loc) {
        if (loc == 0) {
            return 1;
        } else if (loc == 1) {
            return 2;
        } else if (loc == 2) {
            return 4;
        }
        return fun(loc - 1) + fun(loc - 2) + fun(loc - 3);
    }

    public static String tran(char[] arr) {
        Character[] res = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int step = fun(i); // 获取对应位移数

            int newChar = arr[i] + step;
            if ('a' <= newChar && newChar <= 'z') {
                // a-z范围内，直接收集
                res[i] = (char) newChar;
            } else {
                // 超范围再进行下一轮
                res[i] = (char) ((newChar - 'a') % 26 + 'a');
            }
        }
        return Arrays.stream(res).map(String::valueOf).collect(Collectors.joining(""));
    }
}
