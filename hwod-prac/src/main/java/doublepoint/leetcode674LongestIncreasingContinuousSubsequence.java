package doublepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

/**
 * 674. 最长连续递增序列
 */
public class leetcode674LongestIncreasingContinuousSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] ints = Arrays.stream(bf.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        bf.close();

        int lengthOfLCIS = findLengthOfLCIS(ints);
        System.out.println(lengthOfLCIS);
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int max = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                // 5-3=2表示5比3大2个，3到5一共有三个，故再加1
                max = Math.max(i - start + 1, max);
            } else {
                start = i;
            }
        }
        return max;
    }
}
