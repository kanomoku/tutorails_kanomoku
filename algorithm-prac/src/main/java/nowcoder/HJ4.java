package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HJ4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        bf.close();

        List<String> list = new ArrayList<>();
        if (str.length() <= 8) {
            System.out.println(fill(str));
        } else {
            int i = 0;
            while (i < str.length()) {
                if (i + 8 <= str.length()) {
                    String substring = str.substring(i, i + 8);
                    list.add(substring);
                    i = i + 8;
                } else {
                    String substring = str.substring(i);
                    list.add(fill(substring));
                    i = i + 8;
                }
            }
        }

        list.stream().filter(a -> !"".equals(a)).forEach(System.out::println);
    }

    public static String fill(String str) {
        if (str.length() < 8) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = str.length(); i < 8; i++) {
                sb.append(0);
            }
            return sb.toString();
        }
        return str;
    }
}
