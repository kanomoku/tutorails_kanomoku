package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFSUnderstand {
    public static void main(String[] args) {
        // 数据源
        int[] arr = {1, 2, 3, 4, 5};

        // 结果收集容器
        List<List<Integer>> res = new ArrayList<>();

        // Stack动态构建所有情况
        Deque<Integer> stack = new LinkedList();

        dfs(arr, 0, stack, res);

        // 输出结果
        res.forEach(System.out::println);
    }

    public static void dfs(int[] arr, int start, Deque<Integer> stack, List<List<Integer>> res) {
        // 快照、记录瞬时状态
        res.add(new ArrayList<>(stack));

        for (int i = start; i < arr.length; i++) {
            // 递归下去
            stack.push(i);
            dfs(arr, i + 1, stack, res);

            // 回溯上来
            stack.pop();
        }
    }
}
