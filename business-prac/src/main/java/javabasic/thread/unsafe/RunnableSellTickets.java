package thread.unsafe;

public class RunnableSellTickets implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
//        unsafe();
        safe();
    }

    /**
     * 线程不安全
     */
    private void unsafe() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  车票第" + ticket-- + "张");
            } else {
                break;
            }
        }
    }

    /**
     * 线程安全
     */
    private void safe() {
        synchronized (this) {
            while (true) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "       车票第" + ticket-- + "张");
                } else {
                    break;
                }
            }
        }
    }
}
