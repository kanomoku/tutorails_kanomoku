package thread.threadpool;

import java.util.concurrent.Callable;

public class C_callable_OneTask1 implements Callable<String> {// callable有个<V>,这个V就是call函数的返回值类型
    private String name;

    public C_callable_OneTask1(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {// 这儿可以抛出异常，而Runnable接口的run函数不可以
        int i = 5;
        while (i >= 0) {
            System.out.println(Thread.currentThread().getName() + "___" + name + " is working." + "第" + i + "次循环");
            Thread.sleep(500);
            i--;
        }
        return "result of  " + name; // Runnable接口的run函数是没有返回值的
    }
}