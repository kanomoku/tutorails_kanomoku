package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.in;

/**
 * NC52 有效括号序列
 */
public class NC52ValidParenthesisSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        boolean valid = isValid(str);
        System.out.println(valid);
    }

    private static boolean isValid(String s) {
        List<Character> left = Arrays.asList('(', '[', '{');
        List<Character> right = Arrays.asList(')', ']', '}');
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (left.contains(aChar)) {
                stack.push(aChar);
            } else if (right.contains(aChar)) {
                if (stack.isEmpty()) {
                    // 不存在左括号直接右括号的话有问题
                    return false;
                }
                Character pop = stack.pop();
                if (!isPair(pop, aChar)) {
                    // 存在乱序
                    return false;
                }
            }
        }

        // 数量不匹配,还有左括号
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    public static boolean isPair(char c1, char c2) {
        if ('(' == c1 && ')' == c2) {
            return true;
        }
        if ('[' == c1 && ']' == c2) {
            return true;
        }
        if ('{' == c1 && '}' == c2) {
            return true;
        }
        return false;
    }
}
