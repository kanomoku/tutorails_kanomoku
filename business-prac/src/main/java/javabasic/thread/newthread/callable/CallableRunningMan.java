package javabasic.thread.newthread.callable;

import java.util.concurrent.Callable;

public class CallableRunningMan implements Callable<Integer> {
    private String name;

    public CallableRunningMan(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + name + " " + i);
        }
        return 100;
    }
}
