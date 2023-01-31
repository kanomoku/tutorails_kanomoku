package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 *
 */
public class RobotMaze {
    public static void main(String[] args) throws IOException {
        // 构造数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int x = parseInt(bf.readLine());
        int y = parseInt(bf.readLine());
        bf.close();

        int[][] map = new int[x][y];

        // 第一行赋值为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
        }

        // 第一列赋值为1
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
        }

        // 动态规划
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        // 输出结果
        System.out.println(map[x - 1][y - 1]);
    }
}
