package thread.threadMethod;

import java.util.Date;

public class Join_Lock3_ThreadThree extends Thread{
    private Join_Lock2_ThreadTwo two;

    public Join_Lock3_ThreadThree(Join_Lock2_ThreadTwo two) {
        this.two = two;
    }

    public void run(){
        //在two执行过程中 one等待的过程中 three将two对象锁定
        System.out.println(Thread.currentThread().getName() + "   thread_three start:   "+ new Date());
        synchronized (two){
            System.out.println(Thread.currentThread().getName() + "   two is locked: "+ new Date());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "   two is free:   "+ new Date());
        }
        System.out.println(Thread.currentThread().getName() + "   thread_three end:   "+ new Date());
    }
}
