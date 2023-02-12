package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import static java.lang.System.in;

public class HJ2CountTheNumberOfOccurrencesOfACharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        char[] chars = bf.readLine().toLowerCase(Locale.ROOT).toCharArray();
        char[] chars2 = bf.readLine().toLowerCase(Locale.ROOT).toCharArray();
        bf.close();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars2[0]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
