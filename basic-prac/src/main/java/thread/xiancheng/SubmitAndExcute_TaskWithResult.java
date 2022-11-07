package thread.xiancheng;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 功能概要：缓冲线程池实例-submit运行
 */
public class SubmitAndExcute_TaskWithResult implements Callable<String> {

    private int id;

    public SubmitAndExcute_TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     *
     * @return
     * @throws Exception
     */
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "  call()方法被自动调用,Start Time： " + " 日期 ：" + new Date() + " 时间：" + System.currentTimeMillis());
        // 一个模拟耗时的操作
        for (int i = 999999; i > 0; i--) ;
        System.out.println(Thread.currentThread().getName() + "  call()方法被自动调用,End Time： " + " 日期 ：" + new Date() + " 时间： " + System.currentTimeMillis());
        return "返回结果" + Thread.currentThread().getName() + "~~~~" + id;
    }
}
