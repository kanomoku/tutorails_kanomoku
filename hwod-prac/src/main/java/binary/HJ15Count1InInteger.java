package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ15 求int型正整数在内存中存储时1的个数
 */
public class HJ15Count1InInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine());
        bf.close();

        String str = Integer.toBinaryString(num);
        char[] chars = str.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if ('1' == chars[i]) {
                res++;
            }
        }
        System.out.println(res);
    }
}
