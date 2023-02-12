package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * HJ13 句子逆序
 */
public class HJ13ReverseSentence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String str = bf.readLine();
        bf.close();

        List<String> lines = new ArrayList<>();
        List<String> collect = Arrays.stream(str.split(" ")).collect(Collectors.toList());
        for (int i = collect.size() - 1; i >= 0; i--) {
            lines.add(collect.get(i));
        }

        String join = String.join(" ", lines);
        System.out.println(join);
    }
}
