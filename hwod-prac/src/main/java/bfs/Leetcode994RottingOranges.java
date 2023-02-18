package bfs;

import java.util.*;

/**
 * leetcond994. 腐烂的橘子
 */
public class Leetcode994RottingOranges {

    /**
     * 官方答案，需要理解消化
     */
    public int orangesRotting1(int[][] grid) {
        int[] drow = new int[]{-1, 0, 1, 0};
        int[] dcolumn = new int[]{0, -1, 0, 1};

        int rowSize = grid.length; // 行数
        int columnSize = grid[0].length; // 列数

        //   0  1  2  3  4  5
        //   6  7  8  9 10 11
        //  12 13 14 15 16 17
        Deque<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();

        for (int row = 0; row < rowSize; ++row) {
            for (int column = 0; column < columnSize; ++column) {
                if (grid[row][column] == 2) {
                    int code = row * columnSize + column;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int row = code / columnSize;
            int column = code % columnSize;
            for (int k = 0; k < 4; ++k) {
                int nr = row + drow[k];
                int nc = column + dcolumn[k];
                if (0 <= nr && nr < rowSize && 0 <= nc && nc < columnSize && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * columnSize + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    res = depth.get(ncode);
                }
            }
        }

        for (int[] row : grid) { // 网格每一行
            for (int v : row) { // 每一行的每一列
                if (v == 1) { // 值 1 代表新鲜橘子
                    return -1; // 还有新鲜的橘子说明有存活者,返回 -1
                }
            }
        }

        return res;
    }

    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length; // 行数
        int columnSize = grid[0].length; // 列数

        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][columnSize];//表示走过的位置，TRUE→走过，FALSE→没走过
        // 当前业务其实不用加visited辅助的,业务场景用不上,这里是练习一下这个思路

        for (int row = 0; row < rowSize; ++row) {
            for (int column = 0; column < columnSize; ++column) {
                if (grid[row][column] == 2) {
                    queue.offer(getCoordinate(row, column)); // 找到入口
                    visited[row][column] = true;// 其实位置标记为已走过
                }
            }
        }

        int[][] nestStep = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上、下、左、右

        int totalStep = 0;
        boolean isFind = false;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();// queue 动态复制，这里只遍历上一层的元素
            isFind = false; // 判断这一圈是否有新橘子被传染
            for (int i = 0; i < queueSize; i++) { // 遍历上一轮传染的所有橘子
                int[] poll = queue.poll();
                for (int[] ints : nestStep) { // 上下左右取传染
                    int newX = poll[0] + ints[0];  // 获取下一步的X坐标
                    int newY = poll[1] + ints[1];  // 获取下一步的Y坐标
                    if (isValidInGrid(newX, newY, grid) && !visited[newX][newY] && grid[newX][newY] == 1) { // 网格范围内范围内,如果是好橘子
                        int[] newLocation = getCoordinate(newX, newY); // 获取下一步的坐标
                        queue.add(newLocation);// 收集到队列里，会走到的

                        visited[newX][newY] = true;//标记已经处理过

                        grid[newX][newY] = -2; // 腐烂它（值 2 代表腐烂的橘子）
                        isFind = true; // 腐烂了橘子才会计时的,不然最短用时是不准确的
                    }
                }

            }

            if (isFind) {
                totalStep++; // 本层处理完毕，加1处理下一层
            }
        }

        for (int[] row : grid) { // 网格每一行
            for (int v : row) { // 每一行的每一列
                if (v == 1) { // 值 1 代表新鲜橘子
                    return -1; // 还有新鲜的橘子说明有存活者,返回 -1
                }
            }
        }

        return totalStep;
    }

    public int orangesRotting2(int[][] grid) {
        int rowSize = grid.length; // 行数
        int columnSize = grid[0].length; // 列数

        Deque<int[]> queue = new LinkedList<>();

        for (int row = 0; row < rowSize; ++row) {
            for (int column = 0; column < columnSize; ++column) {
                if (grid[row][column] == 2) {
                    queue.offer(getCoordinate(row, column)); // 找到入口
                }
            }
        }

        int[][] nestStep = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上、下、左、右

        int totalStep = 0;
        boolean isFind = false;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();// queue 动态复制，这里只遍历上一层的元素
            isFind = false; // 判断这一圈是否有新橘子被传染
            for (int i = 0; i < queueSize; i++) { // 遍历上一轮传染的所有橘子
                int[] poll = queue.poll();
                for (int[] ints : nestStep) { // 上下左右取传染
                    int newX = poll[0] + ints[0];  // 获取下一步的X坐标
                    int newY = poll[1] + ints[1];  // 获取下一步的Y坐标
                    if (isValidInGrid(newX, newY, grid) && grid[newX][newY] == 1) { // 网格范围内范围内,如果是好橘子
                        int[] newLocation = getCoordinate(newX, newY); // 获取下一步的坐标
                        queue.add(newLocation);// 收集到队列里，会走到的
                        grid[newX][newY] = -2; // 腐烂它（值 2 代表腐烂的橘子）
                        isFind = true; // 腐烂了橘子才会计时的,不然最短用时是不准确的
                    }
                }

            }

            if (isFind) {
                totalStep++; // 本层处理完毕，加1处理下一层
            }
        }

        for (int[] row : grid) { // 网格每一行
            for (int v : row) { // 每一行的每一列
                if (v == 1) { // 值 1 代表新鲜橘子
                    return -1; // 还有新鲜的橘子说明有存活者,返回 -1
                }
            }
        }

        return totalStep;
    }

    public static int[] getCoordinate(int i, int j) {
        return new int[]{i, j};
    }

    public static boolean isValidInGrid(int i, int j, int[][] arr) {
        return 0 <= i && i < arr.length && 0 <= j && j < arr[i].length;
    }
}
