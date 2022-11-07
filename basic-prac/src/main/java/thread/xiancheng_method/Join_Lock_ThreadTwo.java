package thread.xiancheng_method;

import java.util.Date;

public class Join_Lock_ThreadTwo extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "   thread_two start:   "+ new Date());
        Join_Lock_ThreadThree three = new Join_Lock_ThreadThree(this);
        three.start();
        try {
            Thread.sleep(5000);//线程2 5秒
//            three.sleep(5000);//线程3加入到线程2里, 线程3先执行。但是线程2只会等线程3 5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "   thread_two end:   "+ new Date());
    }
}
