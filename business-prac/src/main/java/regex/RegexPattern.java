package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
    public static void main(String[] args) {
        test_CANON_EQ();
        //        test_CASE_INSENSITIVE();
        //        test_COMMENTS();
        //        test_DOTALL();
        //        test_MULTILINE();
        //        test_UNIX_LINES();
        //        test_LITERAL();
        //        test_UNICODE_CHARACTER_CLASS();

    }

    private static void test_UNICODE_CHARACTER_CLASS() {
        Pattern p1 = Pattern.compile("\\w+");
        System.out.println(p1.matcher("中国").matches());
        Pattern p2 = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        System.out.println(p2.matcher("中国").matches());
    }

    private static void test_LITERAL() {
        System.out.println(Pattern.compile("\\s").matcher("\\s").matches()); // false
        System.out.println(Pattern.compile("\\s", Pattern.LITERAL).matcher("\\s").matches()); // true
    }

    private static void test_UNIX_LINES() {
        String data = "A\r\nB\rC\nD";
        System.out.println(data);
        System.out.println("-------------------------------------");

        Matcher m = Pattern.compile(".+").matcher(data);
        while (m.find()) {
            System.out.println("[" + m.group() + "]");  // [A][B][C][D]
        }
        System.out.println("-------------------------------------");

        m = Pattern.compile(".+", Pattern.UNIX_LINES).matcher(data);
        while (m.find()) {
            System.out.println("[" + m.group() + "]");  // （A\r）、（B\rC）、（D）
        }
    }

    private static void test_MULTILINE() {
        System.out.println(Pattern.compile(".*BC").matcher("AB\nBC").find()); // true
        System.out.println(Pattern.compile("^.*BC$").matcher("AB\nBC").find()); // false
        System.out.println(Pattern.compile("^.*BC$").matcher("AB\nBC").matches()); // false

        Matcher m2 = Pattern.compile("^.*BC$", Pattern.MULTILINE).matcher("AB\nBC");
        if (m2.find()) {
            System.out.println(m2.group()); // BC
        }

        Matcher m3 = Pattern.compile("\\A.*BC\\Z", Pattern.MULTILINE).matcher("AB\nBC");
        if (m3.find()) {
            System.out.println(m3.group()); // 没匹配到
        }
    }

    private static void test_DOTALL() {
        System.out.println(Pattern.compile("[A-Z].*").matcher("ABC\nDEF").matches()); // false
        System.out.println(Pattern.compile("[A-Z].*", Pattern.DOTALL).matcher("ABC\nDEF").matches()); // true
        System.out.println("1-------------------------------------");

        Matcher matcher = Pattern.compile("[A-Z].*").matcher("ABC\nDEF");
        while (matcher.find()) {
            System.out.print("," + matcher.group() + "");
        }
        System.out.println();
        System.out.println("2-------------------------------------");

        Matcher matcher2 = Pattern.compile("^[A-Z].*$").matcher("ABC\nDEF");
        while (matcher2.find()) {
            System.out.print("," + matcher2.group() + "");
        }

        System.out.println();
        System.out.println("3-------------------------------------");

        Matcher matcher3 = Pattern.compile("^[A-Z].*$", Pattern.DOTALL).matcher("ABC\nDEF");
        while (matcher3.find()) {
            System.out.print("," + matcher3.group() + "");
        }
        System.out.println();
        System.out.println("4-------------------------------------");
    }

    private static void test_COMMENTS() {
        Pattern p1 = Pattern.compile("#[A-Z]+");
        System.out.println(p1.matcher("#ABC").matches());
        Pattern p2 = Pattern.compile("#[A-Z]+", Pattern.COMMENTS);
        System.out.println(p2.matcher("#ABC").matches());
        Pattern p3 = Pattern.compile("[0-9]+#[A-Z]+", Pattern.COMMENTS);
        System.out.println(p3.matcher("123").matches());
        Pattern p4 = Pattern.compile("[A-Z]+ [0-9]+");
        System.out.println(p4.matcher("ABC123").matches());
        Pattern p5 = Pattern.compile("[A-Z]+ [0-9]+", Pattern.COMMENTS);
        System.out.println(p5.matcher("ABC123").matches());
    }

    private static void test_CASE_INSENSITIVE() {
        System.out.println(Pattern.compile("[A-Z]+", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE).matcher("abc")
            .matches()); // true
        System.out.println(Pattern.compile("(?i)|(?u)[A-Z]+").matcher("abc").matches()); // 忽略 Unicode 中的大小写敏感 // true

        System.out.println(Pattern.compile("[A-Z]+", Pattern.CASE_INSENSITIVE).matcher("abc").matches()); // true
        System.out.println(Pattern.compile("(?i)[A-Z]+").matcher("abc").matches()); // 忽略 US-ASCII字符集中的大小写敏感 // true
    }

    private static void test_CANON_EQ() {
        System.out.println(Pattern.compile("\\u003f", Pattern.CANON_EQ).matcher("?").matches()); // true
    }
}
