package thread.threadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 功能概要：理解FutureTask的作用
 */
public class C_callable_DiZhuChangGong_Dizhu_MainTest {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        C_callable_DiZhuChangGong_ChangGong changgong = new C_callable_DiZhuChangGong_ChangGong();
        FutureTask<Integer> jiangong = new FutureTask<Integer>(changgong);
        //FutureTask<String>是一个包装器，它通过接受Callable<String>来创建，它同时实现了Future和Runnable接口
        new Thread(jiangong, "闰土：").start();

        while (!jiangong.isDone()) {
            System.out.println(Thread.currentThread().getName() + "： 看长工做完了没...");
            Thread.sleep(500);// 地主的main线程 也就是 main 线程
        }

        int amount = jiangong.get();
        System.out.println("工作做完了,上交了" + amount);
    }
}
