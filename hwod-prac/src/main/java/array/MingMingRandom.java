package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ3 明明的随机数
 */
public class MingMingRandom {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        outPut1(bf);

        outPut2(bf);
    }

    private static void outPut1(BufferedReader bf) throws IOException {
        List<Integer> list = new ArrayList<>();

        int num = parseInt(bf.readLine());

        for (int i = 0; i < num; i++) {
            list.add(parseInt(bf.readLine()));
        }
        bf.close();

        list.sort(Comparator.naturalOrder());

        List<Integer> collect = list.stream().sorted().distinct().collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    private static void outPut2(BufferedReader bf) throws IOException {
        Set<Integer> set = new HashSet<>();

        int num = parseInt(bf.readLine());

        for (int i = 0; i < num; i++) {
            set.add(parseInt(bf.readLine()));
        }
        bf.close();

        List<Integer> collect1 = set.stream().sorted().collect(Collectors.toList());

        collect1.forEach(System.out::println);
    }
}
