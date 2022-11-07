package thread.threadDemo;

import java.util.concurrent.Callable;

// 长工类：
// 长工类实现了Callable接口，线程运行完成后返回一个Integer值。
public class C_callable_DiZhuChangGong_ChangGong implements Callable<Integer> {// callable有个<V>,这个V就是call函数的返回值类型

	private int hours = 3;
	private int amount;

	@Override
	public Integer call() throws Exception {
		// 这儿可以抛出异常，而Runnable接口的run函数不可以
		while (hours > 0) {
			System.out.println(Thread.currentThread().getName() + " I'm still working on it......");
			amount += 10;
			hours--;
			Thread.sleep(1000);
		}
		return amount;
		// Runnable接口的run函数是没有返回值的
	}
}