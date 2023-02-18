package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827. 最大人工岛
 */
public class Leetcode827MakingALargeIsland {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}};
        Leetcode827MakingALargeIsland leetcode695MaxAreaOfIsland = new Leetcode827MakingALargeIsland();
        leetcode695MaxAreaOfIsland.largestIsland(grid);
    }

    public int largestIsland(int[][] grid) {
        // 收集所有岛屿的面积
        int islandNum = 2; //每个岛的标号设置成不一致，编号初始值为2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandNum); //求当前岛屿的面积
                    if (area > 0) {
                        map.put(islandNum, area); //岛屿编号-->岛屿面积
                    }
                    islandNum++; // 存储完当前岛屿，改变岛屿编号存储下一个
                }
            }
        }

        // 对所有位置进行填充,获取最大的联通面积
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, plusArea(grid, i, j, map));
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int row, int column, int islandNum) {
        if (!isInGrid(grid, row, column)) {
            return 0;// 不在网格内
        }
        if (grid[row][column] == 0) {
            return 0; // '0'（水）
        }
        if (grid[row][column] != 1) {
            return 0; // 如果已经取过了则返回
        }
        grid[row][column] = islandNum; //给岛屿的这块土地编号，表示已经走过

        // 当前节点面积+上、下、左、右四个相邻结点引申出去计算得到的面积
        return 1 + dfs(grid, row - 1, column, islandNum)
                + dfs(grid, row + 1, column, islandNum)
                + dfs(grid, row, column - 1, islandNum)
                + dfs(grid, row, column + 1, islandNum);
    }

    boolean isInGrid(int[][] grid, int row, int column) {
        return 0 <= row && row < grid.length && 0 <= column && column < grid[row].length;
    }


    public int plusArea(int[][] grid, int row, int column, Map<Integer, Integer> map) {
        if (grid[row][column] != 0) { //如果不是海洋 就不去填海，直接返回当前岛屿的面积
            return map.get(grid[row][column]);
        }

        // 当前节点填海以后会连同上、下、左、右四个相邻结点所在的岛屿联通，找出可以连接的岛屿
        Set<Integer> set = new HashSet<>();// 把当前海洋上所有的所有陆地编号找到，至于为啥用set,是避免把同一个岛屿取两回
        if (isInGrid(grid, row - 1, column) && grid[row - 1][column] != 0) {
            set.add(grid[row - 1][column]);
        }
        if (isInGrid(grid, row + 1, column) && grid[row + 1][column] != 0) {
            set.add(grid[row + 1][column]);
        }
        if (isInGrid(grid, row, column - 1) && grid[row][column - 1] != 0) {
            set.add(grid[row][column - 1]);
        }
        if (isInGrid(grid, row, column + 1) && grid[row][column + 1] != 0) {
            set.add(grid[row][column + 1]);
        }

        // 把联通的岛屿的面积加和
        int res = 0;
        for (Integer integer : set) {
            res += map.get(integer);
        }

        return res + 1; // 四周面积+当前节点面积→连在一起的最大面积
    }
}
