package thread.pool;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class threadPool8_ScheduledThreadPool_FixedRate2 {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
        pool.scheduleAtFixedRate(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "~~" + " Start Time = " + new Date());
                sleep(1000);               // 睡眠 1s，
                System.out.println(Thread.currentThread().getName() + "~~" + " End   Time = " + new Date());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 1, 4, TimeUnit.SECONDS);  // 延迟 1s，周期 2s
    }
}
