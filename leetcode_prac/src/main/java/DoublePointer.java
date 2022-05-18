import org.junit.Test;

import java.util.Arrays;

public class DoublePointer {

    @Test public void test() {

    }

    /**
     * LCP 18. 早餐组合
     *
     * 执行用时：79 ms, 在所有 Java 提交中击败了45.70%的用户
     * 内存消耗：56.5 MB, 在所有 Java 提交中击败了33.56%的用户
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int s = staple.length;
        int d = drinks.length;
        int i = 0;
        int j = d - 1;
        int res = 0;
        while (i < s && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                res = (res + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return res % 1000000007;
    }

    /**
     * LCP 18. 早餐组合
     * 
     * 执行用时：76 ms, 在所有 Java 提交中击败了60.03%的用户
     * 内存消耗：56.3 MB, 在所有 Java 提交中击败了55.82%的用户
     */
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {
        // 先对两份价格进行排序
        Arrays.sort(staple);
        Arrays.sort(drinks);
        // 主食坐标
        int left = 0;
        // 饮料坐标
        int right = drinks.length - 1;
        // 总方案数
        long count = 0;
        while (left < staple.length) {
            // 饮料最多不得超过此数
            int find = x - staple[left];
            while (right >= 0 && drinks[right] > find) {
                right--;
            }
            // 如果饮料价格都大于要寻找的数，则不需要进行后续处理，跳出循环
            if (right < 0) {
                break;
            }
            // 累加方案数
            count += (long)right + 1;
            count %= 1000000007;
            left++;
        }
        return (int)count;
    }
}
