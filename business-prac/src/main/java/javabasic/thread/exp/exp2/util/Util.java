package javabasic.thread.exp.exp2.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class Util {
    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    private static final Random random = new Random();

    // 一个模拟生成0.5秒至2.5秒随机延迟的方法
    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 一个模拟生成1秒随机延迟的方法
    public static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (formatter) {
            return new Double(formatter.format(number));
        }
    }
}
