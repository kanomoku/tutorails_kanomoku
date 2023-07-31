package thread.threadmethod.join;

import java.util.Date;

/**
 * 两个线程合并成一个线程
 */
public class TaskTwoJoinOne extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " → " + " Start Time = " + new Date());

        TaskTwo two = new TaskTwo();
        two.start();
        try {
            two.join(); // 线程two加入到线程one里,two执行完one才开始执行

            // two.join(1000);// 线程two加入到线程one里,就等线程two2000毫秒,超过就不等了

            // two.join(6000);// 最长需等6000ms,如果线程two执行完不需要6000ms，则可以继续执行线程one的内容

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " → " + " End   Time = " + new Date());
    }
}
