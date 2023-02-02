package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * 字符串序列判定
 * abc
 * ahbgdc
 * <p>
 * axc
 * ahbgdc
 */
public class StringSequenceDecision {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        char[] shortWords = bf.readLine().toCharArray();
        char[] longWords = bf.readLine().toCharArray();
        bf.close();

        // 结果收集容器
        boolean res = false;

        res = judge2(shortWords, longWords);

        // 输出结果
        System.out.println(res);
    }

    private static boolean judge1(char[] shortWords, char[] longWords) {
        boolean res = false;
        int index = 0;
        for (int i = 0; i < shortWords.length; i++) {
            while (index < longWords.length) { // 还在有效范围内
                if (shortWords[i] == longWords[index]) { // 字符相等
                    index = index + 1; // 当前字符处理完指针挪到下个位置，为后续做准备
                    i = i + 1; // 如果找到，都进行下一个处理（这里很关键，不然判断完的还在判断）
                    break; // 终止查询，开始处理下个字符
                } else {
                    index = index + 1; // 字符不相等，则开始判断下个字符
                }
            }

            // 长字符串遍历完，短字符串还没有遍历完则表示不是子串
            // 只要短串遍历完，不管长串遍历完与否，短字符串都是子串
            if (i >= shortWords.length - 1) {
                res = true;
            }

            // 长串处理完就直接终止判断
            if (index >= longWords.length - 1) {
                break;
            }
        }
        return res;
    }

    private static boolean judge2(char[] shortWords, char[] longWords) {
        int index = 0;
        for (int i = 0; i < longWords.length; i++) {
            while (index < shortWords.length) { // 还在有效范围内
                if (longWords[i] == shortWords[index]) { // 字符相等
                    if (index >= shortWords.length - 1) {
                        return true;
                    }
                    index = index + 1; // 当前字符处理完指针挪到下个位置，为后续做准备
                    break; // 如果找到，都进行下一个处理（这里很关键，不然判断完的还在判断）
                } else {
                    // 不相等的话，短字符串不动，长字符串挪动到下一位
                    break;
                }
            }
        }

        return false;
    }
}
