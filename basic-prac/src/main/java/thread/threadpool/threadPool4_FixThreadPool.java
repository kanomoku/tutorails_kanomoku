package thread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadPool4_FixThreadPool {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
		ExecutorService exec = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 11; i++) {
			System.out.println("添加了第" + i + "个线程任务");
			exec.execute(new threadPool1_Handle("线程名字" + i));
		}
		exec.shutdown(); // 执行到此处并不会马上关闭线程池
		System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
	}
	// 上面创建了一个固定大小的线程池，大小为5.也就说同一时刻最多只有5个线程能运行。
	// 并且线程执行完成后就从线程池中移出。它也不能保证放入的线程能按顺序执行。这要看在等待运行的线程的竞争状态了。
}
