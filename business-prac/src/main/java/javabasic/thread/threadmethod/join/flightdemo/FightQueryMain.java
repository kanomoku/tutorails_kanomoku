package javabasic.thread.threadmethod.join.flightdemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class FightQueryMain {
    public static void main(String[] args) {
        // 实现一下从SH（上海）到北京（BJ）的航班查询
        List<String> results = flightSearch("SH", "BJ");

        System.out.println("===========result===========");
        results.forEach(System.out::println);
    }

    private static List<String> flightSearch(String original, String dest) {
        //①合作的各大航空公司
        List<String> fightCompanies = Arrays.asList("CSA", "CEA", "HNA");
        //②创建查询航班信息的线程列表
        List<FightQueryTask> queryTasks = fightCompanies.stream().map(fightCompany -> new FightQueryTask(fightCompany, original, dest)).toList();
        //③分别启动这几个线程
        queryTasks.forEach(Thread::start);

        //④分别调用每一个线程的join方法，阻塞当前线程
        queryTasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //⑤当前线程会阻塞住,直到获取每一个查询线程的结果
        return queryTasks.stream()
                .map(FightQuery::getRes)
                .flatMap(Collection::stream)
                .toList();
    }
}