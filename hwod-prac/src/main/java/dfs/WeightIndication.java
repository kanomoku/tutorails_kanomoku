package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ41 称砝码
 */
public class WeightIndication {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        // n种砝码
        int n = parseInt(bf.readLine());
        // 每种砝码重量
        Integer[] weights = Arrays.stream(bf.readLine().split(" ")).limit(n).map(Integer::parseInt).toArray(Integer[]::new);
        // 每种几个
        Integer[] nums = Arrays.stream(bf.readLine().split(" ")).limit(n).map(Integer::parseInt).toArray(Integer[]::new);
        bf.close();

        // 所有砝码重量组合情况set
        HashSet<Integer> allCase = new HashSet<>();

        // 由示例可知，0重量也属于一种情况
        allCase.add(0);

        for (int i = 0; i < n; i++) { //每一种砝码

            HashSet<Integer> current = new HashSet<>();

            for (int k = 1; k <= nums[i]; k++) { // 每种砝码遍历每个
                int stepPlusWeight = weights[i] * k; // 砝码个数叠加枚举
                for (Integer weight : allCase) {
                    current.add(stepPlusWeight);
                    current.add(weight + stepPlusWeight);
                }
            }

            allCase.addAll(current);
        }
        System.out.println(allCase.size());
    }
}
