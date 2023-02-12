package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class HJ1TheLengthOfTheLastWordInTheString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<String> words = Arrays.stream(str.split(" ")).collect(Collectors.toList());
        String s = words.get(words.size() - 1);
        System.out.println(s.length());
    }
}
