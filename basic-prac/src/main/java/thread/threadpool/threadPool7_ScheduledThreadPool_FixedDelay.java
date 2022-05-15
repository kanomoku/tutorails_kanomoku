package thread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class threadPool7_ScheduledThreadPool_FixedDelay {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		for (int i = 1; i < 11; i++) {
			System.out.println("添加了第" + i + "个线程任务 " + new Date());
			executor.scheduleWithFixedDelay(new threadPool1_Handle("线程名字" + i), 2, 10, TimeUnit.SECONDS);
		}
		System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());
		while (!executor.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
	}
}
