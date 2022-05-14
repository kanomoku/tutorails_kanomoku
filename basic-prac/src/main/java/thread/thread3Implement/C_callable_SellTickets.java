package thread.thread3Implement;

import java.util.concurrent.Callable;

public class C_callable_SellTickets implements Callable<Integer> {
    @Override
    public Integer call() {
        int tickets = 0;
        for (; tickets < 5; tickets++) {
            System.out.println(Thread.currentThread().getName() + " 第" + tickets + "次循环");
            System.out.println(Thread.currentThread().getName() + "       车票第" + tickets + "张");
        }
        return tickets;
    }
}
