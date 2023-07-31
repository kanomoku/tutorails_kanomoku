package javabasic.arraybasic;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayBasic {

    @Test
    public void toStr() {
        String[] s1 = {"wyy", "wzz", "wxx", "wxx"};

        String str1 = Arrays.toString(s1); // [wyy, wzz, wxx, wxx]
        String str4 = String.join(",", s1); // wyy,wzz,wxx,wxx
        String str3 = StringUtils.join(s1, ","); // wyy,wzz,wxx,wxx
        String str5 = Arrays.stream(s1).collect(Collectors.joining(",")); // wyy,wzz,wxx,wxx
        String str2 = ArrayUtils.toString(s1); // {wyy,wzz,wxx,wxx}

        System.out.println(str1);
        System.out.println(str4);
        System.out.println(str3);
        System.out.println(str5);
        System.out.println(str2);
    }
}
