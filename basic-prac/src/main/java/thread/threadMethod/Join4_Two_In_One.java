package thread.threadMethod;

import java.util.Date;

public class Join4_Two_In_One extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  thread_one start" + new Date());
        Join2_Two two = new Join2_Two();
        two.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread_one end "+ new Date());
    }
}
//以上这样肯定保证two在one后面执行