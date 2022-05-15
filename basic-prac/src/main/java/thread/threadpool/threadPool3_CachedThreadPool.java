package thread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadPool3_CachedThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ExecutorService exec = Executors.newCachedThreadPool(); // 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        for (int i = 1; i < 11; i++) {
            System.out.println("放进去第" + i + "个任务类");
            exec.execute(new threadPool1_Handle("线程名字" + i));
        }

        exec.shutdown();
        // 执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错.
        // 关闭线程池。正确的方法有两种：一个是让所有的入队任务都执行完毕（shutdown()）， 再就是舍弃这些任务（shutdownNow())

        System.out.println(Thread.currentThread().getName() + " 线程: Finished all threads at：" + new Date());
    }
}
// 从控制台结果可以看出：
// 1、主线程的执行与线程池里的线程分开，有可能主线程结束了，但是线程池还在运行
// 2、放入线程池的线程并不一定会按其放入的先后而顺序执行
