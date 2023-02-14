package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.System.in;

/**
 * NC175 合法的括号字符串
 */
public class NC175ValidParenthesisString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        boolean validString = isValidString(str);
        System.out.println(validString);
    }

    public static boolean isValidString(String s) {
        //新建两个栈left、star，分别记录未匹配的左括号和*号对应下标
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //左括号下标入栈
            if (c == '(') {
                left.push(i);
            }
            //*号下标入栈
            else if (c == '*') {
                star.push(i);
            }
            //如果是右括号
            else {
                //首先匹配左括号
                if (!left.isEmpty()) {
                    left.pop();
                }
                //其次匹配*号
                else if (!star.isEmpty()) {
                    star.pop();
                }
                //如果都没有，说明有右括号找不到匹配对象
                else {
                    return false;
                }
            }
        }

        //检查未匹配的左括号和*号
        while (!left.isEmpty() && !star.isEmpty()) {
            int top1 = left.pop();
            int top2 = star.pop();
            //每一个左括号都必须有一个*号（视为右括号）与之匹配
            if (top1 > top2) {
                return false;
            }
        }

        return left.isEmpty();
    }
}
