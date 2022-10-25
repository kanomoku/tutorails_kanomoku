package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HJ1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.stream(bf.readLine().split(" ")).collect(Collectors.toList());
        bf.close();

        int length = words.get(words.size() - 1).length();
        System.out.println(length);
    }
}
