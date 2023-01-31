package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.System.in;

/**
 * 贪吃蛇
 * R G G
 * 3 3
 * F F F
 * F F H
 * E F E
 */
public class GluttonousSnake {
    public static void main(String[] args) throws IOException {
        // 读取数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        // 收集操作
        char[] actions = bf.readLine().replaceAll(" ", "").toCharArray();

        // 读取方格大小
        int[] size = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = size[0];
        int y = size[1];

        // 填充方格
        char[][] map = new char[x][y];
        for (int i = 0; i < x; i++) {
            char[] s = bf.readLine().replaceAll(" ", "").toCharArray();
            map[i] = s;
        }
        bf.close();

        // 贪吃蛇身体
        Deque<int[]> body = new LinkedList<>();

        // 找到蛇头
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 'H') {
                    body.offerLast(getLocation(i, j));
                    break;
                }
            }
        }

        // 业务逻辑处理
        char tempAction = 0;
        for (Character action : actions) {
            int[] ints = body.peekFirst().clone();
            if ('U' == action) {
                tempAction = 'U';
            } else if ('D' == action) {
                tempAction = 'D';
            } else if ('L' == action) {
                tempAction = 'L';
            } else if ('R' == action) {
                tempAction = 'R';
            } else if ('G' == action) {
                if ('U' == tempAction) {
                    ints[0]--;
                } else if ('D' == tempAction) {
                    ints[0]++;
                } else if ('L' == tempAction) {
                    ints[1]--;
                } else if ('R' == tempAction) {
                    ints[1]++;
                }

                // 出界停止后续操作
                if (!isValid(map, ints[0], ints[1], body)) {
                    break;
                }

                // 如果为食物，只吃不减
                if (map[ints[0]][ints[1]] == 'F') {
                    body.addFirst(getLocation(ints[0], ints[1]));
                } else {
                    // 没迟到食物则，加头去尾
                    body.addFirst(getLocation(ints[0], ints[1]));
                    body.removeLast();
                }
            }

        }

        // 贪吃蛇的长度
        System.out.println(body.size());
    }

    public static boolean isValid(char[][] map, int i, int j, Deque<int[]> body) {
        boolean isValid = true;
        // 判断是否在方格内
        if (!(0 <= i && i < map.length && 0 <= j && j < map[i].length)) {
            return false;
        }

        // 判断是否撞到自己了
        for (int[] ints : body) {
            if (ints[0] == i && ints[1] == j) {
                return false;
            }
        }
        return isValid;
    }

    public static int[] getLocation(int i, int j) {
        return new int[]{i, j};
    }
}
