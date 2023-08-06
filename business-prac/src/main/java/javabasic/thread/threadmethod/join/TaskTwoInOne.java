package javabasic.thread.threadmethod.join;

import java.util.Date;

/**
 * 保证two在one后面执行
 */
public class TaskTwoInOne extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " → " + " Start Time = " + new Date());

        TaskTwo taskTwo = new TaskTwo();
        taskTwo.start();
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