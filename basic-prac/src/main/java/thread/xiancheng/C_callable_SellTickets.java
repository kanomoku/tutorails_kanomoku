package thread.xiancheng;

import java.util.concurrent.Callable;

public class C_callable_SellTickets implements Callable<Integer> {
    public Integer call() throws Exception {
        int tickets = 0;
        for (; tickets < 5; tickets++) {
            System.out.println(Thread.currentThread().getName() + "       车票第" + tickets + "张");
        }
        return tickets;
    }
}
