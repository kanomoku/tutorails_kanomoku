package dfs;

/**
 * leetcode463. 岛屿的周长(只有一个小岛场景)
 */
public class Leetcode463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int row, int column) {
        // 岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量
        if (!isInGrid(grid, row, column)) {
            // 用了非对即错的思路，不需要列举出错误的例子，只要不对那就是错
            return 1;// 岛屿和边界相邻场景
        }
        if (grid[row][column] == 0) { // '0'（水）
            return 1;// 岛屿和水域相邻场景
        }

        if (grid[row][column] == 2) {
            return 0;// 走过的地方
        }

        grid[row][column] = 2; // 每走过一个陆地格子，就把格子的值改为 2,防止走到重复的地方去

        // 上、下、左、右四个相邻结点引申出去计算周长
        return dfs(grid, row - 1, column)
                + dfs(grid, row + 1, column)
                + dfs(grid, row, column - 1)
                + dfs(grid, row, column + 1);
    }

    private boolean isInGrid(int[][] grid, int row, int column) {
        return 0 <= row && row < grid.length && 0 <= column && column < grid[row].length;
    }
}
