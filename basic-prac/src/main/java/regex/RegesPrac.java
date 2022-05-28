package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class RegesPrac {

    /**
     * 如何匹配行首行尾、字符串头字符串尾
     */
    @Test public void test() {
        assertEquals(true, Pattern.compile("^Google\nApple$").matcher("Google\nApple").find());
        assertEquals(false, Pattern.compile("^Google$").matcher("Google\nApple").find());

        Matcher matcher = Pattern.compile("^Google\nApple$", Pattern.DOTALL).matcher("Google\nApple");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        assertEquals(false, Pattern.compile("^Google$", Pattern.DOTALL).matcher("Google\nApple").find());

        Matcher matcher1 = Pattern.compile("^Google\nhttps://juejin.cn/post/7099115273235480589$", Pattern.MULTILINE)
            .matcher("Google\nApple");
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

        Matcher matcher2 = Pattern.compile("^Google$", Pattern.MULTILINE).matcher("Google\nApple");
        while (matcher2.find()) {
            System.out.println(matcher2.group());
        }
    }

    /**
     * 如何匹配行首行尾、字符串头字符串尾
     */
    @Test public void test4() {
        System.out.println(Pattern.compile("^$").matcher("").find());
    }
}
