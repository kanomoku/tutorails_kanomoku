package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * 【算法题】素数之积
 */
public class TheProductOfPrimeNumbers {
    public static void main(String[] args) throws IOException {
        // 收集数据源
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int num = parseInt(bf.readLine());
        bf.close();

        List<Integer> res = getIntegers(num);

        // 输出结果
        if (res.isEmpty()) {
            System.out.println("-1");
        } else {
            String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect);
        }
    }

    /**
     * 判断是否为素数之积
     */
    private static List<Integer> getIntegers(int num) {
        List<Integer> res = new ArrayList<>();

        double sqrt = Math.sqrt(num); // 讨巧算法，两个数相乘最大的也就是平方
        for (int i = 2; i <= sqrt; i++) { // 求素数之积,要跳过1的特殊场景,所以从2开始查找

            if (!isPrime(i)) {
                continue; // 第一个因数不为素数则处理下个数
            }

            if (num % i != 0) {
                continue; // 不能整除则处理下个数
            }

            if (!isPrime(num / i)) {
                continue; // 第二个因数不为素数则处理下个数
            }

            res.add(i);
            res.add(num / i);
        }

        return res;
    }

    /**
     * 判断是不是素数
     */
    public static boolean isPrime(int num) {
        // 2,3
        if (num < 4) {
            return num > 1;
        }

        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) { // 模为0说明整除了
                return false;
            }
        }
        return true;
    }
}
