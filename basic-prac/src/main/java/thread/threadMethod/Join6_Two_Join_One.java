package thread.threadMethod;

import java.util.Date;

//两个线程合并成一个线程
public class Join6_Two_Join_One extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  thread_one start " + new Date());
        Join2_Two two = new Join2_Two();
        two.start();
        try {
            two.join();//线程2加入到线程1里
//            two.join(2000);//就等线程2 2000毫秒 超过就不等了
            two.join(6000);//虽然等6秒但是如果线程2执行完毕的话就不需要等够6秒了，就可以继续执行线程1的内容了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread_one end "+ new Date());
    }
}
