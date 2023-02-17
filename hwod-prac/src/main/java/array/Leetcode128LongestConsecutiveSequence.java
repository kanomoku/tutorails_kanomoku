package array;

import java.util.Arrays;

/**
 * leetcode128 无序整数数组,找出数字连续的最长序列的长度（不要求序列元素在原数组中连续）
 */
public class Leetcode128LongestConsecutiveSequence {

    /**
     * leetcode128 无序整数数组,找出数字连续的最长序列的长度（不要求序列元素在原数组中连续）
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        // 序列起码自己所以初始值为1而非0
        int max = 1;

        int tempMax = 1; // 下边从1开始和前面的值比较,起码有前面这个值,所以tempMax从1开始
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1]) == nums[i]) {
                // 数字连续即要求严格递增，当前处理是针对如下场景
                // [100,4,200,1,3,3,3,3,2] → [1,2,3,4] → 4
                continue;
            }

            if ((nums[i - 1] + 1) == nums[i]) {
                // 符合连续条件
                tempMax++;
            } else {
                max = Math.max(tempMax, max); // 动态收集最大值
                tempMax = 1; // 当前值字符为新一轮的开始,故tempMax其实为1
            }
        }

        // 此处针对最后一位走的是（符合连续条件→然后循环完毕）这种场景
        max = Math.max(tempMax, max);

        return max;
    }
}
