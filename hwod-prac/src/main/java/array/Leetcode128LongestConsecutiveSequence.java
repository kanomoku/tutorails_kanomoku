package array;

import java.util.Arrays;

/**
 * leetcode128 无序整数数组,找出数字连续的最长序列的长度（不要求序列元素在原数组中连续）
 */
public class Leetcode128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int max = 1;
        int tempMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1]) == nums[i]) {
                // 数字连续即表示严格递增
                continue;
            }
            if ((nums[i - 1] + 1) == nums[i]) {
                // 符合连续条件
                tempMax++;
            } else {
                max = Math.max(tempMax, max);
                tempMax = 1;
            }
        }

        max = Math.max(tempMax, max);

        return max;
    }
}
