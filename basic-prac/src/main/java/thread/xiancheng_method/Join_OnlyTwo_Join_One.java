package thread.xiancheng_method;

import java.util.Date;

//两个线程合并成一个线程
public class Join_OnlyTwo_Join_One extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  thread_one start" + new Date());
        Join_OnlyTwo two = new Join_OnlyTwo();
        two.start();
        try {
//            two.join();//线程2加入到线程1里
            two.join(2000);//就等线程2 2000毫秒 超过就不等了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " thread_one end "+ new Date());
    }
}
