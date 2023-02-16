package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode239. 滑动窗口最大值
 * 1 3 -1 -3 5 3 6 7
 * 3
 */
public class SlideWindowMaximumSum_Array {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = Integer.parseInt(bf.readLine());
        bf.close();

        int[] res = maxSlidingWindow(s, size);
        System.out.println(res);
    }

    /**
     * leetcode239. 滑动窗口最大值
     *
     * @param nums 给定数组
     * @param k    大小为 k 的滑动窗口
     */
    private static int[] maxSlidingWindow2(int[] nums, int k) {
        // 收集结果容器
        List<Integer> res = new ArrayList<>();

        // 业务逻辑处理
        for (int i = 0; i <= nums.length - k; i++) {
            int[] ints = Arrays.copyOfRange(nums, i, i + k);
            Arrays.stream(ints).max().ifPresent(res::add);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * leetcode239. 滑动窗口最大值
     *
     * @param nums 给定数组
     * @param k    大小为 k 的滑动窗口
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // top k算法的经典实现是大顶堆和小顶堆
        // 当前为大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1]);

        // 对K个元素构造大顶堆，取最大值
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }

        int arrLen = nums.length;
        // 数组长为6,k为3时,前面3个后面还剩3个,加上前三个最大值还要收集一下,故再+1
        int[] res = new int[arrLen - k + 1];


        res[0] = pq.peek()[0]; // 收集第1个窗口的最大值

        for (int i = k; i < arrLen; ++i) { // 从下标为第k的元素开始处理
            pq.offer(new int[]{nums[i], i}); // 入优先队列

            while (pq.peek()[1] <= i - k) { // 如果当前值还未上一轮最大值的时候，把他删除
                pq.poll();
            }

            res[i - k + 1] = pq.peek()[0]; // 收集第2个窗口的最大值
        }

        return res;
    }
}
