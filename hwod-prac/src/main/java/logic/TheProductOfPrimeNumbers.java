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

        // 收集结果
        List<Integer> res = new ArrayList<>();

        // 讨巧算法，两个数相乘最大的也就是平方
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            // 第一个因数不为素数则返回
            if (!isPrime(i)) {
                continue;
            }
            // 不能整除则返回
            if (num % i != 0) {
                continue;
            }

            // 第二个因数不为素数则返回
            if (!isPrime(num / i)) {
                continue;
            }

            // 输出结果
            res.add(i);
            res.add(num / i);
        }

        // 输出结果
        if (res.isEmpty()) {
            System.out.println("-1");
        } else {
            String collect = res.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect);
        }
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
