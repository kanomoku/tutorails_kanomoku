package math;

/**
 * leetcode204. 计数质数
 */
public class Leetcode204CountPrimes {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    /**
     * 有点高级需要理解，先保存
     */
    public boolean isPrime2(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {  // 模为0说明整除了
                return false;
            }
        }
        return true;
    }

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
