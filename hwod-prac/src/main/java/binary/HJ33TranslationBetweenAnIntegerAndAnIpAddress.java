package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * HJ33 整数与IP地址间的转换
 */
public class HJ33TranslationBetweenAnIntegerAndAnIpAddress {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String temp = "";
        List<String> lines = new ArrayList<>();
        while ((temp = bf.readLine()) != null && temp.length() > 0) {
            lines.add(temp);
        }
        bf.close();

        // 结果收集容器
        List<Object> res = new ArrayList<>();

        // 遍历处理每个IP
        for (int i = 0; i < lines.size(); i++) {
            String str = lines.get(i);
            if (str.contains(".")) { // 10.0.3.193格式的IP
                List<Integer> collect = Arrays.stream(str.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
                String binaryStr = collect.stream().map(a -> fillProZero(Integer.toBinaryString(a), 8)).map(String::valueOf).collect(Collectors.joining(""));
                Long decimalIp = binaryToDecimal(binaryStr);
                res.add(decimalIp);
            } else { // 167969729格式的IP
                String binaryStr = fillProZero(Long.toBinaryString(Long.parseLong(str)), 32);
                List<String> binarySubStr = get8Str(binaryStr);
                String dotIp = binarySubStr.stream().map(a -> binaryToDecimal(a)).map(String::valueOf).collect(Collectors.joining("."));
                res.add(dotIp);
            }
        }

        // 输出结果
        res.stream().forEach(System.out::println);
    }


    /**
     * 字符串8位截取子串
     */
    public static List<String> get8Str(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            if (i + 8 < str.length()) {
                String substring = str.substring(i, i + 8);
                res.add(substring);
                i = i + 8;
            } else {
                String substring = str.substring(i);
                res.add(substring);
                i = i + 8;
            }
        }
        return res;
    }

    /**
     * 不够8位补0
     */
    public static String fillProZero(String str, int base) {
        if (str.length() >= base) {
            return str;
        }
        return fillProZero("0" + str, base);
    }

    /**
     * 2进制到10进制
     */
    public static Long binaryToDecimal(String str) {
        char[] chars = str.toCharArray();
        Long res = 0L;
        for (int i = 0; i < chars.length; i++) {
            int numericValue = Character.getNumericValue(chars[i]);
            res = res * 2 + numericValue;
        }
        return res;
    }
}
