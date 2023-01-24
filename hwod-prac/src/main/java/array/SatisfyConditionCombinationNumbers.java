package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SatisfyConditionCombinationNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(bf.readLine());
        Integer[] arr = Arrays.stream(bf.readLine().split(" ")).limit(total).map(Integer::parseInt).toArray(Integer[]::new);
        bf.close();

        // 降序为了便于快速找到
        Arrays.sort(arr, (a, b) -> b - a);

        // 中间状态flag
        boolean exist = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i] == arr[j] + 2 * arr[k] && i != j && i != k && j != k) {
                        exist = true;
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }

        // 不存在的话输出0
        if (!exist) {
            System.out.println(0);
        }
    }
}
