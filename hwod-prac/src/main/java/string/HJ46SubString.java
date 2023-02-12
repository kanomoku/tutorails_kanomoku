package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ46 截取字符串
 */
public class HJ46SubString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        int num = parseInt(bf.readLine());
        bf.close();

        String substring = str.substring(0, num);
        System.out.println(substring);
    }
}
