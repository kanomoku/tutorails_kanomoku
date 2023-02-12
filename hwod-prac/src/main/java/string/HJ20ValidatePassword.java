package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.System.in;

/**
 * HJ20 密码验证合格程序
 */
public class HJ20ValidatePassword {
    public static void main(String[] arg) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        List<String> res = new ArrayList<>();
        String str = "";
        while ((str = bf.readLine()) != null && str.length() > 0) {
            res.add(validatePassword(str));
        }
        bf.close();

        res.stream().forEach(System.out::println);
    }

    private static String validatePassword(String str) {
        // 1.长度超过8位
        if (str.length() <= 8) {
            return "NG";
        }
        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        if (getMatch(str)) {
            return "NG";
        }
        // 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
        if (hasSameSubStr(str, 0, 3)) {
            return "NG";
        }
        return "OK";
    }


    /**
     * 是否有长度大于2的相同子串 （注：其他符号不含空格或换行）
     */
    private static boolean hasSameSubStr(String str, int l, int r) {
        // 最优化应该是如果截取3位的话应该是r>=str.length()-2,n位应该是r>=str.length()-(n-1)
        if (r >= str.length()) {
            return false;
        }
        // 母串
        String sourceStr = str.substring(r);
        // 子串
        String targetStr = str.substring(l, r);
        // 母串是否包含子串
        if (sourceStr.contains(targetStr)) {
            return true;
        } else {
            return hasSameSubStr(str, l + 1, r + 1);
        }
    }

    /**
     * 包括大小写字母.数字.其它符号,以上四种至少三种
     */
    private static boolean getMatch(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }
}
