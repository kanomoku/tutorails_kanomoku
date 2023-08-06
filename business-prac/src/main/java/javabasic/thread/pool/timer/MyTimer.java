package javabasic.thread.pool.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyTimer {
    private static int count = 1;
    private static List<String> userList = Arrays.asList("a", "b", "c", "d");

    /**
     * 每隔一段时间 发送一些数据
     */
    public static void main(String[] args) throws ParseException {
        System.out.println(Thread.currentThread().getName() + " → " + "预备开始" + new Date());


        Timer timer = new java.util.Timer();
        Date firstTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-05-21 13:25:00");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " → " + "第" + count++ + "次执开始行" + " Start Time = " + new Date());

                for (int i = 0; i < userList.size(); i++) {
                    System.out.println(Thread.currentThread().getName() + "  给 " + userList.get(i) + " 发送一条消息: " + " 恭喜发财 " + new Date());
                }

                System.out.println(Thread.currentThread().getName() + " → " + "第" + count++ + "次执开始行" + " End   Time = " + new Date());
            }
        }, firstTime, 3000);
    }
}
