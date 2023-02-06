package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * NC68 跳台阶
 */
public class StepJumping {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine());
        bf.close();

        StepJumping stepJumping = new StepJumping();
        int i = stepJumping.jumpFloor(num);
        System.out.println(i);
    }

    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
