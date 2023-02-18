package dfs;

import java.io.IOException;

/**
 * 695. 岛屿的最大面积
 */
public class Leetcode695MaxAreaOfIsland {
    public static void main(String[] args) throws IOException {
        int[][] grid = {{0, 0, 1}, {0, 0, 1}, {0, 0, 1}};
        Leetcode695MaxAreaOfIsland leetcode695MaxAreaOfIsland = new Leetcode695MaxAreaOfIsland();
        leetcode695MaxAreaOfIsland.maxAreaOfIsland(grid);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0; // 如果没有岛屿，则返回面积为 0

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) { // 找到一个1就会把接壤的所有1都标记成2，然后遍历完这个岛屿
                    int islandArea = dfs(grid, i, j); // 当前岛屿的面积
                    max = Math.max(max, islandArea); // 动态算出最大面积
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int column) {
        if (!isInGrid(grid, row, column)) {
            return 0; // 不在网格内
        }

        if (grid[row][column] == 0) {
            return 0; // '0'（水）
        }

        if (grid[row][column] == 2) {
            return 0; // 走过的地方
        }

        grid[row][column] = 2; // 每走过一个陆地格子，就把格子的值改为 2,防止走到重复的地方去

        // 当前节点面积+上、下、左、右四个相邻结点引申出去计算得到的面积
        return 1 + dfs(grid, row - 1, column)
                + dfs(grid, row + 1, column)
                + dfs(grid, row, column - 1)
                + dfs(grid, row, column + 1);
    }

    private boolean isInGrid(int[][] grid, int row, int column) {
        return 0 <= row && row < grid.length && 0 <= column && column < grid[row].length;
    }
}
