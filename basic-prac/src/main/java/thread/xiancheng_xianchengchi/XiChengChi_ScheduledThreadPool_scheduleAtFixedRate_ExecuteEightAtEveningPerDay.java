package thread.xiancheng_xianchengchi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 每天晚上9点执行一次 每天定时安排任务进行执行
 */
public class XiChengChi_ScheduledThreadPool_scheduleAtFixedRate_ExecuteEightAtEveningPerDay {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date() + "时间 at: " + System.currentTimeMillis());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // long oneDay = 24 * 60 * 60 * 1000=86400000;
        long oneDay = 5000;
//        long initDelay = getTimeMillis("21:00:00") - System.currentTimeMillis();
//        long initDelay = getTimeMillis("21:00:00") - getTimeMillis("20:59:57");//3000ms
        long initDelay = getTimeMillis("21:00:00") - getTimeMillis("21:00:03");//-3000ms
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        executor.scheduleAtFixedRate(new XiChengChi_Handle("线程名字：定时任务"), initDelay, oneDay, TimeUnit.MILLISECONDS);
        while (!executor.isTerminated()) {
            // wait for all tasks to finish
        }
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }


    /**
     * 获取指定时间对应的毫秒数
     *
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
