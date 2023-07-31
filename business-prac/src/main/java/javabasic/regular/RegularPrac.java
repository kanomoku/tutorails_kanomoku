package regular;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegularPrac {

    @Test
    public void test1() {
        Pattern compile = Pattern.compile("(count)(\\d+)(df)");
        Matcher matcher = compile.matcher("count000dfdfsdffaaaa1");
        if (matcher.find()) {
            System.out.println(matcher.group()); // count000df
            System.out.println(matcher.group(0)); // count000df
            System.out.println(matcher.group(1)); // count
            System.out.println(matcher.group(2)); // 000
            System.out.println(matcher.group(3)); // df
        }
    }

    @Test
    public void test2() {
        // 断言是否包含
        Predicate<String> predicate = Pattern.compile("dalian").asPredicate();

        System.out.println(predicate.test("welcome dalian")); //true
        System.out.println(predicate.test("welcome dalian1")); //true
        System.out.println(predicate.test("welcome dalia")); //false
    }

    @Test
    public void test3() {
        // 按正则分割字符串
        Pattern pattern = Pattern.compile("dalian");
        Stream<String> stream = pattern.splitAsStream("Welcomedalianfordalian!");

        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test4() {
        // 匹配空串
        Pattern compile = Pattern.compile("^$");

        System.out.println(compile.matcher("").find());  //true
        System.out.println(compile.matcher("").matches());  //true
        System.out.println("".matches("^$"));  //true
    }
}
