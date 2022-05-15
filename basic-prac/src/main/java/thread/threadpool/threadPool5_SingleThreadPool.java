package thread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadPool5_SingleThreadPool {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
		ExecutorService exec = Executors.newSingleThreadExecutor(); // 创建大小为1的固定线程池
		// 等价于 ExecutorService exec = Executors.newFixedThreadPool(1);
		for (int i = 1; i < 11; i++) {
			System.out.println("添加了第" + i + "个线程任务");
			exec.execute(new threadPool1_Handle("线程名字" + i));
		}
		exec.shutdown(); // 执行到此处并不会马上关闭线程池
		System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
	}
}
// 其实这个就是创建只能运行一条线程的线程池。它能保证线程的先后顺序执行，并且能保证一条线程执行完成后才开启另一条新的线程
