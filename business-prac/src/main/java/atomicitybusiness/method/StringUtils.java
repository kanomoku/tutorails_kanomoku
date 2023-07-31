package atomicitybusiness.method;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

public class StringUtils {

    @Test public void test_CaseFormat_Type() {
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "family_name_and_last_name"));   // family_name_and_last_name
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, "family_name_and_last_name"));   // FAMILY_NAME_AND_LAST_NAME
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "family_name_and_last_name"));        // familyNameAndLastName
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "family_name_and_last_name"));        // FamilyNameAndLastName
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "family_name_and_last_name"));       // family-name-and-last-name
    }

    @Test public void converterTo() {
        Converter<String, String> converter = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_UNDERSCORE);
        String result = converter.convert("family_name_and_last_name"); // FAMILY_NAME_AND_LAST_NAME

        System.out.println(result);
    }

    @Test public void toUpperCase() {
        System.out.println(Ascii.toUpperCase("aaaBBaa"));  // AAABBAA
        System.out.println(Ascii.toLowerCase("AAAaaAA"));  // aaaaaaa

        System.out.println("aaaBBaa".toUpperCase(Locale.ROOT));  // AAABBAA
        System.out.println("AAAbbAA".toLowerCase(Locale.ROOT));  // aaabbaa
    }

    /**
     * 字符串大小写转化
     * 大写字母多 → 全转大写
     * 小写字母多 → 全转小写
     * 大小写一样多 → 不转化保留当前字符串
     */
    public static String caseConver(String str) {
        int lower = str.length() - str.replaceAll("[a-z]", "").length(); // 统计大写字母个数
        int upper = str.length() - str.replaceAll("[A-Z]", "").length(); // 统计小写字母个数

        if (lower > upper) {
            return str.toLowerCase(Locale.ROOT);
        } else if (lower < upper) {
            return str.toUpperCase(Locale.ROOT);
        } else {
            return str;
        }

//        System.out.println(caseConver("ABCdefgh")); // abcdefgh
//        System.out.println(caseConver("ABCDefgh")); // ABCDefgh
//        System.out.println(caseConver("ABCDEfgh")); // ABCDEFGH
    }

    /**
     * 判断子串是不是回文子串
     */
    public static boolean isPalindrome(String s) {
        // null, ""（空字符串场景）, "a"（单字符字符串场景）
        if (s == null || s.length() <= 1) {
            return true;
        }

        // 知识点1: [0,arr.length/2)为数组对称部分左一半
        // abcba  奇数时 5/2=2 范围for (int i = 0; i < 2; i++) [0 1] ② 3 4
        // abccba 偶数时 6/2=3 范围for (int i = 0; i < 3; i++) [0 1 2] ③ 4 5
        int strLength = s.length();
        for (int i = 0; i < strLength / 2; i++) {

            // 知识点2: 数组折叠对应下标相加为length - 1
            if (s.charAt(i) != s.charAt(strLength - 1 - i)) // 不相等
                return false;
        }

        // 知识点3: 基于找事思路，存在不符合条件的就算失败，不然就算通过
        return true;

//        System.out.println(isPalindrome("abccba")); // true
//        System.out.println(isPalindrome("aa"));     // true
//        System.out.println(isPalindrome("abc"));    // false
//        System.out.println(isPalindrome("ab"));     // false
//        System.out.println(isPalindrome("a"));      // true
//        System.out.println(isPalindrome(""));       // true
//        System.out.println(isPalindrome("  "));     // true
    }

    /**
     * 定义一个单词的 "兄弟单词" 为：
     * 交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。且兄弟单词要求和原来的单词不同。
     * 例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
     */
    public static boolean isBro(String str, String target) {
        // 长度不等指定不为兄弟单词
        if (str.length() != target.length()) {
            return false;
        }

        // 兄弟单词要求和原来的单词不同
        if (str.equals(target)) {
            return false;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        char[] targets = target.toCharArray();
        Arrays.sort(targets);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != targets[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isBro("abd","abd"));
        System.out.println(isBro("",""));
        System.out.println(isBro("abd","aswd"));
        System.out.println(isBro("abd",""));
        System.out.println(isBro("abd","ade"));
        System.out.println(isBro("abc","acb"));
    }
}
