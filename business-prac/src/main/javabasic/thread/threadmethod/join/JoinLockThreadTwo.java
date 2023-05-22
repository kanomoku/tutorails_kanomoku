package thread.threadmethod.join;

import java.util.Date;

public class JoinLockThreadTwo extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread___two start: "+ new Date());

        JoinLockThreadThree three = new JoinLockThreadThree(this);
        three.start();

        try {
            Thread.sleep(5000);//线程2 5秒
//            three.join(5000);//线程3加入到线程2里, 线程3先执行。但是线程2只会等线程3 5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " thread___two end: "+ new Date());
    }
}
