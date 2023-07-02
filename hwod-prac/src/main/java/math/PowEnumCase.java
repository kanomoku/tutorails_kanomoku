package math;

import java.math.BigDecimal;

public class PowEnumCase {
    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            double pow = Math.pow(2, i);
            BigDecimal bigDecimal = new BigDecimal(pow);
            String s = bigDecimal.toPlainString();
            System.out.println("2的" + fillProZero(String.valueOf(i), 3) + "次方: " + fillProZero(s, 20));
        }
    }

    public static String fillProZero(String str, int base) {
        if (str.length() >= base) {
            return str;
        }
        return fillProZero("0" + str, base);
    }
}
