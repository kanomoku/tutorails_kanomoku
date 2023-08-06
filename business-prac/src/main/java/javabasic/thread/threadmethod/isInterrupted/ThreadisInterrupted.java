package javabasic.thread.threadmethod.isInterrupted;

import java.util.concurrent.TimeUnit;

public class ThreadisInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
            //do nothing, just empty loop.
            }
        });
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);

        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
