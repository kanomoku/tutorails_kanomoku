package dfs;

/**
 * leetcode200. 岛屿数量
 */
public class Leetcode200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandCnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((grid[i][j]) == '1') { // 找到一个1就会把接壤的所有1都标记成2，然后遍历完这个岛屿
                    dfs(grid, i, j);
                    islandCnt++; // 表示已经找到一个岛屿
                }
            }
        }

        return islandCnt;
    }

    void dfs(char[][] grid, int row, int column) {
        if (!isInGrid(grid, row, column)) {
            return; // 不在网格内
        }

        if (grid[row][column] == '0') {
            return; // '0'（水）
        }

        if (grid[row][column] == '2') {
            return; // 走过的地方
        }

        grid[row][column] = '2'; // 每走过一个陆地格子，就把格子的值改为 2,防止走到重复的地方去

        // 访问上、下、左、右四个相邻结点
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }

    /**
     * 判断坐标 (r, c) 是否在网格中
     */
    private boolean isInGrid(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
