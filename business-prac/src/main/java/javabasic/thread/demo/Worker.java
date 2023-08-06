package javabasic.thread.demo;

import java.util.concurrent.Callable;

/**
 * 长工类
 */
public class Worker implements Callable<Integer> {
    private int hours = 3;
    private int amount;

    @Override
    public Integer call() throws Exception {
        while (hours > 0) {
            System.out.println(Thread.currentThread().getName() + " I'm still working on it......");
            amount += 100;
            hours--;
            Thread.sleep(1000);
        }
        return amount;
    }
}