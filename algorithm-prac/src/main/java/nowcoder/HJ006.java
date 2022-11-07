package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ6 质数因子
 */
public class HJ006 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(bf.readLine());
        bf.close();

        double sqrt = Math.sqrt(num);

        for (long i = 2; i <= sqrt; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "" : num);
    }

    public static boolean isPrime(double d) {
        if (d < 4) {
            return d > 1;
        }
        double sqrt = Math.sqrt(d);

        for (int i = 2; i <= sqrt; i++) {
            if (d % i == 0) {
                return false;
            }
        }
        return true;
    }
}
