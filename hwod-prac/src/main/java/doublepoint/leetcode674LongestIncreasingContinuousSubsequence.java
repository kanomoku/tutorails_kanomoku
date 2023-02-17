package doublepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

/**
 * leetcode 674. 无序整数数组的最长且连续递增的子序列
 */
public class leetcode674LongestIncreasingContinuousSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] ints = Arrays.stream(bf.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        bf.close();

        int lengthOfLCIS = findLengthOfLCIS2(ints);
        System.out.println(lengthOfLCIS);

        int[] lengthOfLCIS1 = findLengthOfLCIS1(ints);
        System.out.println(Arrays.toString(lengthOfLCIS1));
    }

    /**
     * leetcode 674. 无序整数数组的最长且连续递增的子序列的长度
     */
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
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

    /**
     * leetcode 674. 无序整数数组的最长且连续递增的子序列的长度
     */
    public static int findLengthOfLCIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int max = 1;

        int tempMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tempMax++;
            } else {
                max = Math.max(tempMax, max);
                tempMax = 1;
            }
        }
        max = Math.max(tempMax, max);

        return max;
    }

    /**
     * leetcode 674. 无序整数数组的最长且连续递增的子序列
     */
    public static int[] findLengthOfLCIS1(int[] nums) {
        if (nums.length < 2) { // 2个一下不涉及排序
            return nums;
        }

        int max = 1;
        int[] temp = {nums[0]};  // 下边从1开始和前面的值比较,起码有前面这个值,所以收集第一个元素应对[2,2,2,2,2]这种场景

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (i - start + 1 > max) {
                    max = i - start + 1;
                    // 方法1：直接截取数组
                    temp = Arrays.copyOfRange(nums, start, i + 1);
                    // 方法2：记录开始结束坐标最后再截取
                }
            } else {
                start = i;
            }
        }

        return temp;
    }
}
