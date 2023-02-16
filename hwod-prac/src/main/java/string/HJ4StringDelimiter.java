package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

/**
 * HJ4 字符串分隔
 */
public class HJ4StringDelimiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<String> res = splitSubStrings(str);

        res.forEach(System.out::println);
    }

    /**
     * 字符串8位一截取，不够8位后面补0
     */
    private static List<String> splitSubStrings(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() == 0) {
            return res;
        }

        for (int i = 0; i < str.length(); ) {
            if (i + 8 < str.length()) {
                String substring = str.substring(i, i + 8);
                res.add(substring);
                i = i + 8;
            } else {
                String substring = str.substring(i);
                res.add(fillStr(substring));
                i = i + 8;
            }
        }
        return res;
    }

    public static String fillStr(String str) {
        if (str.length() >= 8) {
            return str;
        }
        return fillStr(str + "0");
    }
}
