package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toLowerCase(Locale.ROOT);
        String str1 = bf.readLine().toLowerCase(Locale.ROOT);
        bf.close();

        int x = getX(str, str1);

        System.out.println(x);
    }

    private static int getX(String str, String str1) {
        // 替换去重的思路
        String target = str1.substring(0, 1);
        String str2 = str.replaceAll(target, "");
        return str.length() - str2.length();
    }
}
