package thread.threadmethod.join;

import java.util.Date;

public class JoinLockThreadThree extends Thread{
    private JoinLockThreadTwo two;

    public JoinLockThreadThree(JoinLockThreadTwo two) {
        this.two = two;
    }

    public void run(){
        //在two执行过程中 one等待的过程中 three将two对象锁定
        System.out.println(Thread.currentThread().getName() + " thread_three start: "+ new Date());

        synchronized (two){
            System.out.println(Thread.currentThread().getName() + " two is locked: "+ new Date());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " two is free: "+ new Date());
        }

        System.out.println(Thread.currentThread().getName() + " thread_three end: "+ new Date());
    }
}