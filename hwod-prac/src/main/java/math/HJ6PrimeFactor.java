package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * HJ6 质数因子
 */
public class HJ6PrimeFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        Long num = Long.parseLong(bf.readLine());
        bf.close();

        List<Long> res = getPrimes(num);

        // 输出素数因子
        String str = res.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(str);
    }

    /**
     * 收集质数因子
     */
    private static List<Long> getPrimes(Long num) {
        List<Long> res = new ArrayList<>();

        // Math.sqrt(num)两数相乘最大的也就是平方，再往后就是重复值了
        double sqrt = Math.sqrt(num);
        for (long i = 2L; i <= sqrt; i++) {
            while (num % i == 0) {
                res.add(i);
                num = num / i;
            }
        }

        // num==1说明全部整除开了，num!=1说明余下本身为素数
        if (num != 1) {
            res.add(num);
        }
        return res;
    }
}
