package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * 1614. 括号的最大嵌套深度
 */
public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        int max = maxDepth(str);
        System.out.println(max);

    }

    private static int maxDepth(String s) {
        // 最大值
        int max = 0;
        // 动态调整值
        int temp = 0;

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if ('(' == aChar) {
                temp++;
                max = Math.max(max, temp); // 取峰值
            } else if (')' == aChar) {
                temp--;
            }
        }
        return max;
    }
}
