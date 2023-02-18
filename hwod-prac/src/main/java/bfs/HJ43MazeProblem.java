package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.System.in;

/**
 * HJ43 迷宫问题
 */
public class HJ43MazeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] size = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 构造网格
        int row = size[0]; // 行
        int column = size[1]; // 列
        int[][] grid = new int[row][column];
        for (int i = 0; i < row; i++) {
            int[] col = Arrays.stream(bf.readLine().split(" ")).limit(column).mapToInt(Integer::parseInt).toArray();
            grid[i] = col;
        }
        bf.close();

        Point minDistance = getMinDistance(grid);

        Deque<int[]> res = new LinkedList<>();
        while (minDistance != null) {
            res.addFirst(getCoordinate(minDistance.row, minDistance.column));
            minDistance = minDistance.father;
        }

        res.stream().forEach(p -> System.out.println("(" + p[0] + "," + p[1] + ")"));
    }


    public static Point getMinDistance(int[][] grid) {
        Deque<Point> queue = new LinkedList<>(); // 队列记录下一步的所有情况
        boolean[][] visited = new boolean[grid.length][grid[0].length];//表示走过的位置，TRUE→走过，FALSE→没走过

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) { // 表示找到入口,这里其实不用两层循环、只是练习一下这个思路
                    queue.add(getNode(i, j, null));
                    visited[i][j] = true;// 其实位置标记为已走过
                    break;
                }
            }
        }

        int[][] nestStep = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上、下、左、右

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int m = 0; m < queueSize; m++) {
                Point poll = queue.poll();
                for (int[] ints : nestStep) { // 上、下、左、右、四种可能性都遍历走一遍
                    int newX = poll.row + ints[0]; // 获取下一步的X坐标
                    int newY = poll.column + ints[1]; // 获取下一步的Y坐标
                    if (isValidInGrid(newX, newY, grid) && newX == grid.length - 1 && newY == grid[0].length - 1) { //范围内，如果下一步时出口的话，直接走一步出去
                        return getNode(newX, newY, poll); // 最后一个节点
                    }
                    if (isValidInGrid(newX, newY, grid) && !visited[newX][newY] && grid[newX][newY] == 0) {//范围内，没走过，不是障碍物
                        queue.add(getNode(newX, newY, poll));
                        visited[newX][newY] = true;//标记已经处理过
                    }
                }
            }
        }

        return null; // 表示没找到
    }

    public static int[] getCoordinate(int i, int j) {
        return new int[]{i, j};
    }

    public static Point getNode(int i, int j, Point fatherNode) {
        return new Point(i, j, fatherNode);
    }

    public static boolean isValidInGrid(int i, int j, int[][] arr) {
        return 0 <= i && i < arr.length && 0 <= j && j < arr[i].length;
    }

}

class Point {
    int row;
    int column;
    Point father;

    Point(int px, int py, Point father) {
        this.row = px;
        this.column = py;
        this.father = father;
    }
}