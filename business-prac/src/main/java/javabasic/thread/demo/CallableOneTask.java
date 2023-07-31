package thread.demo;

import java.util.concurrent.Callable;

public class CallableOneTask implements Callable<String> {
    private String name;

    public CallableOneTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        int i = 5;
        while (i >= 0) {
            System.out.println(Thread.currentThread().getName() + " " + name + " " + i--);
            Thread.sleep(500);
        }
        return Thread.currentThread().getName() + " 执行完毕,返回结果 ";
    }
}