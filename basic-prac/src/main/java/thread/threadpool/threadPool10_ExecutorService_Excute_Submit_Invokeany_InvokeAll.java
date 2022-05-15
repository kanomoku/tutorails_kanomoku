package thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class threadPool10_ExecutorService_Excute_Submit_Invokeany_InvokeAll {
	public static void main(String args[]) throws InterruptedException, ExecutionException {

		// execute(Runnable) ：
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		executorService.execute(new Runnable() {
//			public void run() {
//				System.out.println("Asynchronous task");
//			}
//		});
//		executorService.shutdown();

		// submit(Runnable) ：
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		Future future = executorService.submit(new Runnable() {
//			public void run() {
//				System.out.println("Asynchronous task");
//			}
//		});
//		// 可以用Future 接，但是Runnable不会有返回值的。
//		System.out.println("future.get()=" + future.get());
//		executorService.shutdown();

		// submit(Callable) ：
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future future = executorService.submit(new Callable() {
//            public Object call() throws Exception {
//                System.out.println("Asynchronous Callable");
//                return "Callable Result";
//            }
//        });
//        System.out.println("future.get() = " + future.get());
//        executorService.shutdown();

		// invokeAny(…)
		// invokeAny将第一个得到的结果作为返回值，然后立刻终止所有的线程。如果设置了超时时间，未超时完成则正常返回结果，如果超时未完成则报超时异常。
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Set<Callable<String>> callables = new HashSet<Callable<String>>();
//
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 1";
//            }
//        });
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 2";
//            }
//        });
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 3";
//            }
//        });
//        callables.add(new Callable<String>() {
//            public String call() throws Exception {
//                return "Task 4";
//            }
//        });
//        String result = executorService.invokeAny(callables);
//        System.out.println("result = " + result);
//        executorService.shutdown();

		// invokeAll(...)
		// invokeAll触发执行任务列表，返回的结果顺序也与任务在任务列表中的顺序一致.所有线程执行完任务后才返回结果。如果设置了超时时间，未超时完成则正常返回结果，如果超时未完成则报异常。
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        List<Callable<String>> callables = new ArrayList();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(callables);

        for (Future<String> future : futures) {
            System.out.println("future.get = " + future.get());
        }
        executorService.shutdown();
	}
}
