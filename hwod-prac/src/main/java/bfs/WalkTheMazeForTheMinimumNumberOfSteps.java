package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 走迷宫、求最少步数
 * 3
 * #S#
 * ...
 * E##
 */
public class WalkTheMazeForTheMinimumNumberOfSteps {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine());
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = bf.readLine();
        }
        bf.close();

        // 数据源变体
        int[][] map = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int i1 = 0; i1 < num; i1++) {
                if (strArr[i].charAt(i1) == 'S') {
                    map[i][i1] = -1;
                } else if (strArr[i].charAt(i1) == 'E') {
                    map[i][i1] = 2;
                } else if (strArr[i].charAt(i1) == '#') {
                    map[i][i1] = 1;
                } else {
                    map[i][i1] = 0;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -1) { // 表示找到入口
                    System.out.println(getMinDistance(map, i, j));
                }
            }
        }

    }

    public static int[] getLocation(int i, int j) {
        int[] location = new int[2];
        location[0] = i;
        location[1] = j;
        return location;
    }

    public static boolean isValidInMap(int i, int j, int[][] arr) {
        return 0 <= i && i < arr.length && 0 <= j && j < arr[i].length;
    }

    public static int getMinDistance(int[][] map, int i, int j) {
        // 结果收集容器
        int totalStep = 0;
        // 中间辅助变量
        boolean[][] visited = new boolean[map.length][map.length];//表示走过的位置，TRUE→走过，FALSE→没走过
        visited[i][j] = true;// 其实位置标记为已走过

        // 中间辅助变量
        Queue<int[]> queue = new LinkedList<>(); // 队列记录下一步的所有情况

        int[] location = getLocation(i, j);// 第一步的坐标
        queue.add(location); // 第一步开始走

        int[][] nestStep = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 左右上下

        while (!queue.isEmpty()) {
            int queueSize = queue.size();// queue 动态复制，这里只遍历上一层的元素
            for (int i1 = 0; i1 < queueSize; i1++) {
                int[] poll = queue.poll();
                for (int[] ints : nestStep) {
                    int newX = poll[0] + ints[0];  // 获取下一步的X坐标
                    int newY = poll[1] + ints[1];  // 获取下一步的Y坐标
                    if (isValidInMap(newX, newY, map) && map[newX][newY] == 2) { //范围内，如果下一步时出口的话，直接走一步出去
                        return totalStep + 1;
                    }
                    if (isValidInMap(newX, newY, map) && !visited[newX][newY] && map[newX][newY] == 0) {//范围内，没走过，不是障碍物
                        int[] newLocation = getLocation(newX, newY); // 获取下一步的坐标
                        queue.add(newLocation);// 收集到队列里，会走到的
                        visited[newX][newY] = true;//标记已经处理过
                    }
                }

            }
            totalStep++; // 本层处理完毕，加1处理下一层
        }
        return -1; // 表示没找到
    }
}
