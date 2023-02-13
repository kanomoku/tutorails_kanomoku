package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * NC100 把字符串转换成整数(atoi)
 */
public class NC100StringToInt {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        int res = StrToInt(str);
        System.out.println(res);
    }

    /**
     * NC100 把字符串转换成整数(atoi)
     */
    public static int StrToInt(String s) {
        //空串
        if (s.isEmpty()) {
            return 0;
        }

        int length = s.length();

        int index = 0;
        //去掉前导空格，如果有
        while (index < length) {
            if (s.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }
        //去掉空格就什么都没有了
        if (index == length) {
            return 0;
        }

        int operator = 1;
        //处理第一个符号是正负号的情况
        if (s.charAt(index) == '+')
            index++;
        else if (s.charAt(index) == '-') {
            index++;
            operator = -1;
        }

        //去掉符号就什么都没有了
        if (index == length) {
            return 0;
        }

        int res = 0;
        while (index < length) {
            char chr = s.charAt(index);
            //后续非法字符，截断
            if (chr < '0' || chr > '9') {
                break;
            }
            // 处理越界
            // 因为如果越界被显示导致记错错误但是不会报错，所以这里才往前推判断出界
            // 基于公式res = res * 10 + operator * (chr - '0');
            // Integer.MAX_VALUE 2147483647
            // Integer.MAX_VALUE / 10 214748364
            // Integer.MAX_VALUE % 10 7
            // 如上值就会理解为何要如此判断
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (chr - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            // Integer.MAX_VALUE -2147483648
            // Integer.MAX_VALUE / 10 -214748364
            // Integer.MAX_VALUE % 10 -8
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (chr - '0') < (Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + operator * (chr - '0');
            index++;
        }

        return res;
    }
}
