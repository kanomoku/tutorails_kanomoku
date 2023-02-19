package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * NC61.两数之和
 */
public class NC61SumOfTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] arr = Arrays.stream(bf.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int num = parseInt(bf.readLine());
        bf.close();

        int[] res = getIntegers(arr, num);

        String collect = Arrays.stream(res).boxed().sorted(Comparator.naturalOrder()).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    /**
     * NC61.两数之和
     */
    private static int[] getIntegers(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                continue;
            }
            // 这种判断存在的场景时不存在回头路的，有回头也是前面收集过的，所以j=i+1
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }
}
