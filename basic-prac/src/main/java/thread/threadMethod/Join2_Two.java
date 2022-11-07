package thread.threadMethod;

import java.util.Date;

public class Join2_Two extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  thread_two start" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread_two end "+ new Date());
    }
}
