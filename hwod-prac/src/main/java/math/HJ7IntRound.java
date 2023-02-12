package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * HJ7 取近似值
 */
public class HJ7IntRound {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        Double num = Double.parseDouble(bf.readLine());
        bf.close();

        int round = getRound2(num);
        System.out.println(round);
    }

    private static long getRound1(Double num) {
        long round = Math.round(num);
        return round;
    }

    private static int getRound2(Double num) {
        return (int) (num + 0.5);
    }
}
