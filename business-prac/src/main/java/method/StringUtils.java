package method;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.junit.Test;

public class StringUtils {

    @Test public void test1() {
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "family_name_and_last_name"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, "family_name_and_last_name"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "family_name_and_last_name"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "family_name_and_last_name"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "family_name_and_last_name"));
    }

    @Test public void test2() {
        Converter<String, String> converter = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_UNDERSCORE);
        String result = converter.convert("family_name_and_last_name");
        System.out.println(result);
    }

    @Test public void test3() {
        System.out.println(Ascii.toUpperCase("aaaaa"));
        System.out.println(Ascii.toLowerCase("AAAAA"));
    }

}
