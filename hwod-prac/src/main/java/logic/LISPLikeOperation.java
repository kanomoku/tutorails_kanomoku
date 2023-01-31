package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.System.in;

/**
 * 仿LISP运算
 * (sub (mul 2 4) (div 9 3))
 * (sub (mul 2 4) (div 9 0))
 * (div 1 0)
 * (add 1 2)
 * (mul 3 -7)
 */
public class LISPLikeOperation {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        Deque<String> operationStack = new LinkedList<>();
        Deque<Integer> numsStack = new LinkedList<>();
        String res = "";

        for (int i = 0; i < str.length(); ) {
            if ('(' == str.charAt(i)) { // 遇到(就去收集运算符
                i = i + 1; // 跳过(
                String opera = str.substring(i, i + 3); // 操作符入栈
                operationStack.push(opera);
                i = i + 3; // 跳过运算符
            } else if (')' == str.charAt(i)) { // 遇到)就去收集运算符
                i = i + 1; // 跳过)
                res = cal(operationStack, numsStack);
                // 报错则停止循环
                if ("error".equals(res)) {
                    break;
                }
            } else {
                if (' ' == str.charAt(i)) {
                    i = i + 1; // 跳过空格
                } else {
                    int temp = i; // 记录初始位置
                    while (Character.isDigit(str.charAt(i)) || '-' == str.charAt(i)) { // 如果当前字符时数字或者负号时
                        i = i + 1; // 跳过当前字符，继续处理下个字符
                    }
                    String num = str.substring(temp, i); // 取到当前数值
                    numsStack.push(Integer.parseInt(num)); // 运算数入栈
                }
            }
        }

        // 输出结果
        if ("success".equals(res)) {
            // 最后所有数都会计算为1个结果
            System.out.println(numsStack.pop());
        } else {
            System.out.println(res);
        }
    }

    public static String cal(Deque<String> operationStack, Deque<Integer> numsStack) {
        Integer popLast = numsStack.pop();
        Integer popFirst = numsStack.pop();
        String operation = operationStack.pop();
        if ("add".equals(operation)) {
            numsStack.push(popFirst + popLast);
        } else if ("sub".equals(operation)) {
            numsStack.push(popFirst - popLast);
        } else if ("mul".equals(operation)) {
            numsStack.push(popFirst * popLast);
        } else if ("div".equals(operation)) {
            if (popLast == 0) {
                return "error";
            }
            numsStack.push(popFirst / popLast);
        }
        return "success";
    }
}
