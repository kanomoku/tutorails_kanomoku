package odexam;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class face2 {
    public static void main(String[] args) throws IOException {
//        给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//        假设网格的四条边均被水包围。
//        输入：[1, 0, 1], [0, 1, 1], [1, 0, 0]
//        输出：3

        face2 prac = new face2();
        int[][] arr = {{1, 0, 1}, {0, 1, 1}, {1, 0, 0}};
        System.out.println(prac.getNum(arr));
    }

    public  int getNum(int[][] grip) {
        int count = 0;
        for (int i = 0; i < grip.length; i++) {
            for (int j = 0; j < grip.length; j++) {
                if (grip[i][j] == 1) {
                    dfs(i, j, grip);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int[][] grip) {
        if (!inGrid(i, j, grip)) {
            return;
        }
        if (grip[i][j] == 0) {
            return;
        }
        if (grip[i][j] == 2) {
            return;
        }
        if (grip[i][j] == 1) {
            grip[i][j] = 2; // 标记走过的
        }
        dfs(i - 1, j, grip);// 上
        dfs(i + 1, j, grip);// 下
        dfs(i, j - 1, grip);// 左
        dfs(i, j + 1, grip);// 右
    }
    public boolean inGrid(int i, int j, int[][] grip) {
        return 0 <= i && i < grip.length && 0 <= j && j < grip[0].length;
    }
}
