package thread.xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class C_callable_OneTask_MainTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<String> oneCallable = new C_callable_OneTask("1");
        FutureTask<String> ft = new FutureTask<String>(oneCallable);//FutureTask<String>是一个包装器，它通过接受Callable<String>来创建，它同时实现了Future和Runnable接口
        new Thread(ft).start();

        while (!ft.isDone()) {
            System.out.println("检查线程执行完了吗...");
            Thread.sleep(1000);  //main 线程
        }

        String result = ft.get();
        System.out.println(result);
    }

}
