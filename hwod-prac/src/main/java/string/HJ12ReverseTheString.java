package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * HJ12 字符串反转
 */
public class HJ12ReverseTheString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }
}
