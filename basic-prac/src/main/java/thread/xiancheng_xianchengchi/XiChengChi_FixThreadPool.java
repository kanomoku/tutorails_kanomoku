package thread.xiancheng_xianchengchi;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建固定数目线程的线程池。
 * <p>
 * 任意时间点，最多只能有固定数目的活动线程存在，
 * 调用execute,先查看池中有没有以前建立的线程,如果有就reuse以前构造的线程,
 * 但不能随时建新的线程,此时如果有新的线程要建立，只能放在另外的队列中等待，直到当前的线程中某个线程终止直接被移出池子.
 * -和cacheThreadPool不同，FixedThreadPool没有IDLE机制（可能也有，但既然文档没提，肯定非常长，类似依赖上层的TCP或UDP IDLE机制之类的）,所以FixedThreadPool多数针对一些很稳定很固定的正规并发线程，多用于服务器.
 * -从方法的源代码看，cache池和fixed池调用的是同一个底层池，只不过参数不同:
 * fixed池线程数固定，并且是0秒IDLE（无IDLE）. cache池线程数支持0-Integer.MAX_VALUE(显然完全没考虑主机的资源承受能力）， 60 秒IDLE
 */
public class XiChengChi_FixThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            System.out.println("添加了第" + i + "个线程");
            exec.execute(new XiChengChi_Handle("线程名字" + i));
        }
        exec.shutdown(); // 执行到此处并不会马上关闭线程池
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
    // 上面创建了一个固定大小的线程池，大小为5.也就说同一时刻最多只有5个线程能运行。
    // 并且线程执行完成后就从线程池中移出。它也不能保证放入的线程能按顺序执行。这要看在等待运行的线程的竞争状态了。
}
