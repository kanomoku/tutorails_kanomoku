package regex;

import org.checkerframework.checker.regex.qual.Regex;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class RegesPrac {

    public static void testPattern(String str, String regex) {
        testPattern(str, regex, Pattern.DOTALL);
    }

    public static void testPattern(String str, String regex, Integer pattern) {
        Matcher matcher = Pattern.compile(regex, pattern).matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    private void matchs(String str, String rex) {
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    /**
     * 如何匹配行首行尾、字符串头字符串尾
     */
    @Test
    public void emptyString() {
        System.out.println(Pattern.compile("^$").matcher("").find());
    }

    @Test
    public void lazy() {
        testPattern("aaaabccccbdddbeee", "a.*?b");
        testPattern("aaaabccccbdddbeee", "a.*b");
    }

    @Test
    public void test_anchor_() {
//        String regex1 = "^Google\nApple";
//        String regex1 = "\\AGoogle\nApple";
//        testPattern("Google\nApple", regex1);
//        System.out.println("1--------------------------------");
//        testPattern("Google\nApple\n", regex1);
//        System.out.println("11--------------------------------");
//        testPattern("\nGoogle\nApple\n", regex1);
//        System.out.println("111--------------------------------");
//        testPattern("Google\nApple\nBanana", regex1);
//        System.out.println("1111--------------------------------");

//        String regex2 = "Google\nApple$";
//        String regex2 = "Google\nApple\\Z";
//        String regex2 = "Google\nApple\\Z";
//        String regex2 = "Google\nApple\\z";
//        testPattern("Google\nApple", regex2);
//        System.out.println("2--------------------------------");
//        testPattern("Google\nApple\n", regex2);
//        System.out.println("22--------------------------------");
//        testPattern("\nGoogle\nApple", regex2);
//        System.out.println("222--------------------------------");
//        testPattern("Banana\nGoogle\nApple", regex2);
//        System.out.println("2222--------------------------------");
//        testPattern("Banana\nGoogle\nApple\nOrange", regex2);
//        System.out.println("22222--------------------------------");

//        String regex3 = "^Google\nApple$";
//        String regex3 = "\\AGoogle\nApple\\Z";
//        String regex3 = "\\AGoogle\nApple\\z";
//        testPattern("Google\nApple", regex3);
//        System.out.println("3--------------------------------");
//        testPattern("Google\nApple\n", regex3);
//        System.out.println("33--------------------------------");
//        testPattern("\nGoogle\nApple", regex3);
//        System.out.println("333--------------------------------");
//        testPattern("Google\nApple\nBanana", regex3);
//        System.out.println("3333--------------------------------");
//        testPattern("Google\nApple", "\\AGoogle\\z");
//        System.out.println("33333--------------------------------");
    }

    @Test
    public void test_anchor_A_Z_z() {
//        String regex1 = "^Google\nApple";
//        testPattern("Google\nApple", regex1, Pattern.MULTILINE);
//        System.out.println("1--------------------------------");
//        testPattern("Google\nApple\n", regex1, Pattern.MULTILINE);
//        System.out.println("11--------------------------------");
//        testPattern("\nGoogle\nApple\n", regex1, Pattern.MULTILINE);
//        System.out.println("111--------------------------------");
//        testPattern("Google\nApple\nBanana", regex1, Pattern.MULTILINE);
//        System.out.println("1111--------------------------------");

//        String regex2 = "Google\nApple$";
//        testPattern("Google\nApple", regex2, Pattern.MULTILINE);
//        System.out.println("2--------------------------------");
//        testPattern("Google\nApple\n", regex2, Pattern.MULTILINE);
//        System.out.println("22--------------------------------");
//        testPattern("\nGoogle\nApple", regex2, Pattern.MULTILINE);
//        System.out.println("222--------------------------------");
//        testPattern("Banana\nGoogle\nApple", regex2, Pattern.MULTILINE);
//        System.out.println("2222--------------------------------");
//        testPattern("Banana\nGoogle\nApple\nOrange", regex2, Pattern.MULTILINE);
//        System.out.println("22222--------------------------------");

//        String regex3 = "^Google\nApple$";
//        testPattern("Google\nApple", regex3, Pattern.MULTILINE);
//        System.out.println("3--------------------------------");
//        testPattern("Google\nApple\n", regex3, Pattern.MULTILINE);
//        System.out.println("33--------------------------------");
//        testPattern("\nGoogle\nApple", regex3, Pattern.MULTILINE);
//        System.out.println("333--------------------------------");
//        testPattern("Google\nApple\nBanana", regex3, Pattern.MULTILINE);
//        System.out.println("3333--------------------------------");
//        testPattern("Google\nApple", "^Google$", Pattern.MULTILINE);
//        System.out.println("33333--------------------------------");
    }

    @Test
    public void test_anchor_b() {
        String str = "中文问号？123_!英文???小括号()中括号[]大括号{}问号?制表符\t空格符 换行符\n";
        String rex = "\\b";

        Pattern pattern = Pattern.compile(rex);
        List<String> list = pattern.splitAsStream(str).toList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("分割字符串:" + "[" + list.get(i) + "]");
        }
    }

    @Test
    public void test_anchor_b2() {
        matchs(" 2 ", "\\b2\\b");
        matchs("!2@", "\\b2\\b");
        matchs("2", "\\b2\\b");
        matchs("121", "\\b2\\b");
    }

    @Test
    public void test_anchor_b3() {
        testPattern(" 目标字段 ", "\\b目标字段\\b");
        System.out.println("1--------------------------------");
        testPattern(" 目标字段！ ", "\\b目标字段\\b");
        System.out.println("11--------------------------------");
        testPattern(" 目标字段1 ", "\\b目标字段\\b");
        System.out.println("111--------------------------------");
        testPattern(" 目标字段哈 ", "\\b目标字段\\b");
        System.out.println("1111--------------------------------");
        testPattern(" 哈哈目标字段哈 ", "\\b目标字段\\b");
        System.out.println("11111--------------------------------");
        testPattern(" 目标字段_ ", "\\b目标字段\\b");
        System.out.println("111111--------------------------------");
    }

    @Test
    public void test_anchor_B() {
        String str = "中文问号？123_!英文???小括号()中括号[]大括号{}问号?制表符\t空格符 换行符\n";
        String rex = "\\B";
        Pattern pattern = Pattern.compile(rex);
        List<String> list = pattern.splitAsStream(str).toList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("分割字符串:" + "→" + list.get(i) + "←");
        }
    }

    @Test
    public void test_anchor_B2() {
        matchs(" 2 ", "\\B2\\B");
        matchs("!2@", "\\B2\\B");
        matchs("2", "\\B2\\B");
        matchs("121", "\\B2\\B");
    }

    @Test
    public void test_anchor_B3() {
        testPattern(" 目标字段 ", "\\B目标字段\\B");
        System.out.println("1--------------------------------");
        testPattern(" 目标字段！ ", "\\B目标字段\\B");
        System.out.println("11--------------------------------");
        testPattern(" 目标字段1 ", "\\B目标字段\\B");
        System.out.println("111--------------------------------");
        testPattern(" 目标字段哈 ", "\\B目标字段\\B");
        System.out.println("1111--------------------------------");
        testPattern(" 哈哈目标字段哈 ", "\\B目标字段\\B");
        System.out.println("11111--------------------------------");
        testPattern(" 目标字段_ ", "\\B目标字段\\B");
        System.out.println("111111--------------------------------");
    }

    @Test
    public void test_anchor_G() {
        String str = "user18dsdfuser2dsfsduser32323hjkuser555";
        String rex1 = "user\\d*";

        Matcher matcher = Pattern.compile(rex1).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
