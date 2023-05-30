package thread.threadmethod.join;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //① 定义两个线程，并保存在threads中
        List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).toList();
        //② 启动这两个线程
        threads.forEach(Thread::start);

        //③ 执行这两个线程的join方法
        for (Thread thread : threads) {
            thread.join();
        }

        //④ main线程循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    //构造一个简单的线程，每个线程只是简单的循环输出
    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        }, String.valueOf(seq));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}