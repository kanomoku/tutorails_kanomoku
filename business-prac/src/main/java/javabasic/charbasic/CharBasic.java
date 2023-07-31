package javabasic.charbasic;

import org.junit.Test;

import java.util.Locale;

public class CharBasic {

    @Test
    public void char_num() {
        boolean b0 = 'a' == 97;       //true
        boolean b1 = 'a' == 97.0;     //true
        boolean b2 = 'a' == 97.0d;    //true
        boolean b3 = 'a' == 97.0f;    //true


        int a0 = 'a';      //97
        double a1 = 'a';   //97.0

        char d0 = 98;           //b
        char d1 = (char) 98.0;  //b

        System.out.println(b0);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        System.out.println(a0);
        System.out.println(a1);

        System.out.println(d0);
        System.out.println(d1);
    }

    @Test
    public void isDigit() {
        boolean digit1 = Character.isDigit('2'); //true
        boolean digit2 = Character.isDigit('0'); //true
        boolean digit3 = Character.isDigit('a'); //false
        boolean digit4 = Character.isDigit('!'); //false

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);
    }

    @Test
    public void isLetterOrDigit() {
        boolean digit1 = Character.isLetterOrDigit('2'); //true
        boolean digit2 = Character.isLetterOrDigit('0'); //true
        boolean digit3 = Character.isLetterOrDigit('a'); //true
        boolean digit4 = Character.isLetterOrDigit('!'); //false

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);
    }

    @Test
    public void isLetter() {
        boolean digit1 = Character.isLetter('2'); //false
        boolean digit2 = Character.isLetter('0'); //false
        boolean digit3 = Character.isLetter('a'); //true
        boolean digit4 = Character.isLetter('!'); //false

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);
    }

    @Test
    public void isLowerCase() {
        boolean digit1 = Character.isLowerCase('2'); //false
        boolean digit2 = Character.isLowerCase('A'); //false
        boolean digit3 = Character.isLowerCase('a'); //true
        boolean digit4 = Character.isLowerCase('!'); //false

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);
    }

    @Test
    public void isUpperCase() {
        boolean digit1 = Character.isUpperCase('2'); //false
        boolean digit2 = Character.isUpperCase('A'); //true
        boolean digit3 = Character.isUpperCase('a'); //false
        boolean digit4 = Character.isUpperCase('!'); //false

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);
    }

    @Test
    public void isWhitespace() {
        boolean digit1 = Character.isWhitespace('2');  //false
        boolean digit2 = Character.isWhitespace('\n'); //true
        boolean digit3 = Character.isWhitespace(' ');  //true
        boolean digit4 = Character.isWhitespace('!');  //false

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);
    }

    @Test
    public void getNumericValue() {
        char ch1 = '1';
        char ch2 = '2';

        // 字符的ASCLL码
        int ch11 = ch1; // 49
        int ch21 = ch2; // 50

        // 数字字符的字面量
        int numericValue1 = Character.getNumericValue(ch1); // 1
        int numericValue2 = Character.getNumericValue(ch2); // 2

        System.out.println(ch11);
        System.out.println(ch21);
        System.out.println(numericValue1);
        System.out.println(numericValue2);
    }

    @Test
    public void toCharArray() {
        String str = "1,2,3,4,5";

        char c = str.charAt(2); // 2

        char[] cs = str.toCharArray(); // 1,2,3,4,5

        System.out.println(c);
        System.out.println(cs);
    }

    /**
     * 字符串ASC码+偏移量实现加密
     */
    public static char isBro(char c, int offset) {
        // 字符串ASC码+偏移量实现加密
        int newChar = c + offset;

        if (newChar < 'a') {
            // <a 给个默认值
            return 'a';
        } else if ('a' <= newChar && newChar <= 'z') {
            // a-z范围内，直接收集
            return (char) newChar;
        } else {
            // >z 取模算结果
            return (char) ((newChar - 'a') % 26 + 'a');
        }
    }

    /**
     * 统计字符个数 （忽略大小写）
     */
    public static int countChars(String str, char targetChar) {
        char[] chars = str.toCharArray();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                count++;
            }
        }

        return count;
    }

    /**
     * 统计字符个数 （区分大小写）
     */
    public static int countCharsIgnoreCase(String str, char targetChar) {
        char[] chars = str.toLowerCase(Locale.ROOT).toCharArray();
        char c = Character.toLowerCase(targetChar);

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
            }
        }

        return count;
    }
}