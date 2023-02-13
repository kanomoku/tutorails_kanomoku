package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * HJ70 矩阵乘法计算量估算
 */
public class HJ70CalculationOfMatrixMultiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        // 矩阵组数
        int groups = parseInt(bf.readLine());
        // 收集矩阵
        int[][] matrix = new int[groups][2];
        for (int i = 0; i < groups; i++) {
            int[] s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i][0] = s[0];
            matrix[i][1] = s[1];
        }
        // 矩阵运算顺序
        String actionStr = bf.readLine();
        bf.close();

        int sum = getSum(groups, matrix, actionStr);
        System.out.println(sum);

        int result = getSum2(matrix, actionStr);
        System.out.println(result);
    }

    private static int getSum(int groups, int[][] matrix, String actionStr) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>(); // 存放矩阵行数和列数
        int j = groups - 1;
        for (int i = actionStr.length() - 1; i >= 0; i--) {
            if ('A' <= actionStr.charAt(i) && actionStr.charAt(i) <= 'Z') {
                stack.push(matrix[j][1]); // 先入栈列
                stack.push(matrix[j][0]); // 再入栈行
                j--;
            } else if (actionStr.charAt(i) == '(') {

                // 先入栈列再入栈行,所以先取出来行再取出来列
                int x0 = stack.pop();
                int y0 = stack.pop(); // 矩阵尺寸x0*y0
                int x1 = stack.pop();
                int y1 = stack.pop(); // 矩阵尺寸x1*y1
                sum += x0 * y0 * y1;  // 两个矩阵的乘法次数为x0*y1*y0或x0*y1*x1（其中y0==x1）
                stack.push(y1);       // 把相乘后得到的矩阵列数入栈
                stack.push(x0);       // 把相乘后得到的矩阵行数入栈
            }
        }
        return sum;
    }

    private static int getSum2(int[][] matrix, String actionStr) {
        int index = 0;
        int result = 0;
        Deque<int[]> stack1 = new LinkedList<>(); // 存放矩阵行数和列数
        for (int i = 0; i < actionStr.length(); i++) {
            if (actionStr.charAt(i) == '(') {
                // 啥也不做
            } else if ('A' <= actionStr.charAt(i) && actionStr.charAt(i) <= 'Z') {
                stack1.push(matrix[index]);
                index++;
            } else if (actionStr.charAt(i) == ')') {
                int[] pop2 = stack1.pop();
                int[] pop1 = stack1.pop();
                result += pop1[0] * pop2[1] * pop1[1];
                int[] newMatrix = {pop1[0], pop2[1]};
                stack1.push(newMatrix);
            }
        }
        return result;
    }
}
