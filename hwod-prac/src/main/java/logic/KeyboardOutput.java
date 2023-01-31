package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

/**
 * 1 输入a
 * 2 复制
 * 3 剪切
 * 4 粘贴
 * 5 全选
 */
public class KeyboardOutput {
    public static void main(String[] args) throws IOException {
        // 构造数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int[] actions = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bf.close();

        // 中间变量
        String screen = ""; // 显示器
        String clip = "";  // 剪切板
        boolean isSelected = false; // 是否被选中

        // 业务逻辑
        for (int action : actions) {
            if (action == 1) { // 输入a
                if (isSelected) {
                    screen = "a"; // 选中的话把值覆盖
                    isSelected = false;
                } else {
                    screen += "a"; // 字符串后面拼接
                }
            } else if (action == 2) { // 复制
                if (isSelected) { // 选中的话，屏幕的值复制到剪切板
                    clip = screen;
                } else {
                    // 没有选中的话，复制无效
                }
            } else if (action == 3) { // 剪切
                if (isSelected) { // 选中的话，屏幕的值复制到剪切板，屏幕清空
                    clip = screen;
                    screen = "";
                    isSelected = false;
                } else {
                    // 没有选中的话，复制无效
                }
            } else if (action == 5) { // 全选
                isSelected = true;
            } else if (action == 4) { // 粘贴
                if (isSelected) { // 选中的话把值替换
                    screen = clip;
                    isSelected = false;
                } else {
                    screen += clip; // 没选中从后面拼接

                }
            }
        }

        // 输出结果
        System.out.println(screen.length());
    }
}
