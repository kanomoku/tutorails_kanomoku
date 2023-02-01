package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class StrSplit {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine()); // 截取长度
        String str = bf.readLine(); // 要处理的字符串
        bf.close();

        // 结果收集容器
        StringBuilder sb = new StringBuilder();

        // 找出来第一个子串并收集
        String[] split = str.split("-");
        sb.append(split[0]);

        // 构造新子字符串
        String newStr = Arrays.stream(split).skip(1).collect(Collectors.joining(""));

        // 收集子串方法1
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < newStr.length(); ) {
            String substring;
            if (i + num <= newStr.length()) { // 右边界还在范围内时，表示还可以继续截取
                substring = newStr.substring(i, i + num); // 截取字符串
                i = i + num; // 收集截取的子串
            } else { // 字符串还没有全部截完,余下长度不够截取时，把余下的收集起来
                substring = newStr.substring(i); // 收集余下的子串
                i = i + num; // 收集截取的子串
            }
            lines.add(converter(substring));
        }

        // 收集子串方法2
        List<String> lines2 = new ArrayList<>();
        String substring1;
        int index = 0;
        while (newStr.length() - index >= num) { // 截取完的长度>= num的话，还可以截取
            substring1 = newStr.substring(index, index + num); // 截取字符串
            lines2.add(converter(substring1)); // 收集截取的子串
            index = index + num; // 移动下标

        }
        if (newStr.length() > index) { // 余下长度不够截取时，如果字符串还没有全部截完时，把余下的收集起来
            substring1 = newStr.substring(index); // 收集余下的子串
            lines2.add(converter(substring1));
        }

        // 输出结果
        String join = String.join("-", lines);
        sb.append("-").append(join);
        System.out.println(sb);
    }

    /**
     * 大小写转换
     */
    public static String converter(String str) {
        // 统计大写字母数
        int upperNum = str.length() - str.replaceAll("[A-Z]", "").length();
        // 统计小写字母数
        int lowerNum = str.length() - str.replaceAll("[a-z]", "").length();
        if (upperNum > lowerNum) {
            return str.toUpperCase(Locale.ROOT);
        } else if (upperNum < lowerNum) {
            return str.toLowerCase(Locale.ROOT);
        } else {
            return str;
        }
    }
}
