package thread.threadMethod;

import java.util.Date;

public class Join_Lock1_ThreadOne extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() +"   thread_one start:  "+ new Date());
        Join_Lock2_ThreadTwo two = new Join_Lock2_ThreadTwo();
        two.start();
        try {
            two.join(2000);//线程2加入到线程1里, 线程2先执行。但是线程1只会等线程2 2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"   thread_one end:   "+ new Date());
    }
}
