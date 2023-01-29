package optimumValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * 力扣1614. 括号的最大嵌套深度
 * (1+(2*3)+((8)/4))+1
 * (1)+((2))+(((3)))
 */
public class TheMaximumNestingDepthOfParentheses {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        char[] chars = bf.readLine().toCharArray();
        bf.close();

        // 结果收集容器
        int total = 0;
        // 中间临时变量
        int temp = 0;

        // 业务逻辑
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('(' == aChar) {
                temp++; // 遇到左括号就+1
                total = Math.max(temp, total); // 动态去峰值
            } else if (')' == aChar) {
                temp--; // 遇到右括号就-1
            } else {
                // 其他字符啥也不做
            }
        }

        // 输出结果
        System.out.println(total);
    }
}
