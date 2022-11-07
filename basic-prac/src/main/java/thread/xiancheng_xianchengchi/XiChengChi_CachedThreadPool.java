package thread.xiancheng_xianchengchi;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可缓存的线程池
 * <p>
 * 调用execute,先查看池中有没有以前建立的线程,如果有就reuse以前构造的线程（如果线程可用）,如果没有，就建一个新的线程加入池中.
 * 能reuse的线程，必须是timeout IDLE内的池中线程，缺省timeout是60s,超过这个IDLE时长，线程实例将被终止及移出池。
 * 注意：放入CachedThreadPool的线程不必担心其结束，超过TIMEOUT不活动，其会自动被终止。
 * 缓存型池子通常用于执行一些生存期很短的异步型任务,因此在一些面向连接的daemon型SERVER中用得不多。但对于生存期短的异步任务，它是Executor的首选。
 */
public class XiChengChi_CachedThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        ExecutorService exec = Executors.newCachedThreadPool(); // 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        for (int i = 0; i < 10; i++) {
            System.out.println("放进去第" + i + "个线程");
            exec.execute(new XiChengChi_Handle("线程名字" + i));
        }
        exec.shutdown();
        // 执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错.
        // 关闭线程池。正确的方法有两种：一个是让所有的入队任务都执行完毕（shutdown()）， 再就是舍弃这些任务（shutdownNow())
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}
// 从控制台结果可以看出：
// 1、主线程的执行与线程池里的线程分开，有可能主线程结束了，但是线程池还在运行
// 2、放入线程池的线程并不一定会按其放入的先后而顺序执行

