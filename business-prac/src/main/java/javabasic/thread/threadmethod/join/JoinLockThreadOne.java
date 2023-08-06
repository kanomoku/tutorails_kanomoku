package javabasic.thread.threadmethod.join;

import java.util.Date;

public class JoinLockThreadOne extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() +" thread___one start: "+ new Date());

        JoinLockThreadTwo two = new JoinLockThreadTwo();
        two.start();

        try {
            two.join(2000);//线程2加入到线程1里, 线程2先执行。但是线程1只会等线程2 2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +" thread___one end: "+ new Date());
    }
}
