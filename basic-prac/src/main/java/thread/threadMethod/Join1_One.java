package thread.threadMethod;

import java.util.Date;

public class Join1_One extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() + "  thread_one start" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread_one end "+ new Date());
    }
}