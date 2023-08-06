package javabasic.thread.pool.newScheduledThreadPool;

import javabasic.thread.pool.newCustomThreadPool.Task;

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
public class FixedRateDemo {
    public static void main(String args[]) throws InterruptedException, ExecutionException, ParseException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // long oneDay = 24 * 60 * 60 * 1000=86400000; // 1天24小时作为周期
        // long initDelay = getTimeMillis("21:00:00") - System.currentTimeMillis(); // 当前时间

        long oneDayPeriod = 10000; // 正常1天=24*60*60*1000=86400000ms,这里用5s来模拟
//        long initDelay = getTimeMillis("21:00:00") - getTimeMillis("20:59:57"); // 假设模拟此时当天的20:59:57 → 3000ms
        long initDelay = getTimeMillis("21:00:00") - getTimeMillis("21:00:03"); // 假设模拟此时当天的21:00:03 →-3000ms

        initDelay = initDelay > 0 ? initDelay : oneDayPeriod + initDelay;

        executor.scheduleAtFixedRate(new Task("定时任务"), initDelay, oneDayPeriod, TimeUnit.MILLISECONDS);
    }


    /**
     * 获取指定时间对应的毫秒数
     */
    private static long getTimeMillis(String time) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
        Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
        return curDate.getTime();
    }
}
