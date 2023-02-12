package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class HJ4StringDelimiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < str.length(); ) {
            if (i + 8 < str.length()) {
                String substring = str.substring(i, i + 8);
                res.add(substring);
                i = i + 8;
            } else {
                String substring = str.substring(i);
                String s = fillStr(substring);
                res.add(s);
                i = i + 8;
            }
        }

        res.forEach(System.out::println);
    }

    public static String fillStr(String str) {
        if (str.length() >= 8) {
            return str;
        }
        return fillStr(str + "0");
    }
}
