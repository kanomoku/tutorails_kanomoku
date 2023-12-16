package javabasic.thread.threadmethod.join.flightdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// 查询Fight的task，其实就是一个线程的子类，主要用于到各大航空公司获取数据
public class FightQueryTask extends Thread implements FightQuery {
    private final String origin;
    private final String destination;
    private final List<String> flightMsgs = new ArrayList<>();

    /**
     *
     * @param airline 航空公司
     * @param origin 始发站
     * @param destination 目的地
     */
    public FightQueryTask(String airline, String origin, String destination) {
        super("[" + airline + "]"); // 学到了这里居然是给线程起名字
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Query from " + origin + " to " + destination);

        // 模拟业务逻辑处理
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        shortSleep(randomVal);
        flightMsgs.add(getName() + "-" + randomVal);

        System.out.println(getName() + "query done");
    }

    @Override
    public List<String> getRes() {
        return this.flightMsgs;
    }

    private static void shortSleep(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
