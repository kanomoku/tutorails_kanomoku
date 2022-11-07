package thread.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C_callable_OneTask3_newCachedThreadPool_MainTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		// Future 相当于是用来存放Executor执行的结果的一种容器

		for (int i = 1; i < 4; i++) {
			results.add(exec.submit(new C_callable_OneTask1("线程" + i)));
		}
		exec.shutdown();
//        下面的例子不好，不是想要的结果
		for (Future<String> fs : results) {
			try {
				while (!fs.isDone()) {
					Thread.sleep(500);
					System.out.println("Future result is not yet complete");
				}
				System.out.println(fs.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
