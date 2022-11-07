package thread.threadpool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//core美 [kɔːr]
//pool美 [puːl]

public class threadPool2_UserDefined {
    public static void main(String[] args) {
    	
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
        
        // 创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        // 创建线程池，池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, bqueue);
        
        // 创建七个任务
        // 每个任务会在一个线程上执行
        for (int i = 1; i < 8; i++) {
            System.out.println("添加了第" + i + "个任务类");
            pool.execute(new threadPool1_Handle("线程任务-" + i));
        }
        // 关闭线程池
        pool.shutdown();
        System.out.println(Thread.currentThread().getName() + "线程: 打卡：" + new Date());
        
        while (!pool.isTerminated()) {
            // wait for all tasks to finish
        }
        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}

//从结果中可以看出，七个任务是在线程池的三个线程上执行的。
//
//   根据ThreadPoolExecutor源码前面大段的注释，我们可以看出，当试图通过excute方法将一个Runnable任务添加到线程池中时，按照如下顺序来处理：
//   1、 如果线程池中的线程数量少于corePoolSize，即使线程池中有空闲线程，也会创建一个新的线程来执行新添加的任务；
//   2、 如果线程池中的线程数量大于等于corePoolSize，但缓冲队列workQueue未满，则将新添加的任务放到workQueue中，按照FIFO的原则依次等待执行（线程池中有线程空闲出来后依次将缓冲队列中的任务交付给空闲的线程执行）；
//   3、 如果线程池中的线程数量大于等于corePoolSize，且缓冲队列workQueue已满，但线程池中的线程数量小于maximumPoolSize，则会创建新的线程来处理被添加的任务；
//   4、 如果线程池中的线程数量等于了maximumPoolSize，有4种处理方式（该构造方法调用了含有5个参数的构造方法，并将最后一个构造方法为RejectedExecutionHandler类型，它在处理线程溢出时有4种方式，这里不再细说，要了解的，自己可以阅读下源码）。
//
//   总结起来，也即是说，当有新的任务要处理时，先看线程池中的线程数量是否大于corePoolSize，再看缓冲队列workQueue是否满，最后看线程池中的线程数量是否大于maximumPoolSize。
//   另外，当线程池中的线程数量大于corePoolSize时，如果里面有线程的空闲时间超过了keepAliveTime，就将其移除线程池，这样，可以动态地调整线程池中线程的数量。