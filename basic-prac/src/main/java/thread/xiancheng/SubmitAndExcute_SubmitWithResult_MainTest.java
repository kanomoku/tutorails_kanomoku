package thread.xiancheng;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitAndExcute_SubmitWithResult_MainTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "线程: Starting at: " + new Date());

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            System.out.println("添加了第" + i + "个线程");
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new SubmitAndExcute_TaskWithResult(i));
            // 将任务执行结果存储到List中
            resultList.add(future);
        }
        // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        executorService.shutdown();

        System.out.println(Thread.currentThread().getName() + "线程: 打卡" + new Date());

        // 遍历任务的结果
        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
            }
        }

        System.out.println(Thread.currentThread().getName() + "线程: Finished all threads at：" + new Date());
    }
}