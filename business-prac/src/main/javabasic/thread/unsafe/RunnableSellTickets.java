package thread.unsafe;

public class RunnableSellTickets implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
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

//    @Override
//    public void run() {
//        while (true) {
//            if (ticket > 0) {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "  车票第" + ticket-- + "张");
//            } else {
//                break;
//            }
//        }
//    }
}
