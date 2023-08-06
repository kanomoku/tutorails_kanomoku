package javabasic.thread.threadmethod.join;

import java.util.Date;

public class TaskTwo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " → " + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " → " + " End   Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
