package thread.xiancheng;

public class B_Runnable_SellTickets implements Runnable {

    private int ticket = 5;

    //        public void run() {
//        //非线程安全，这就需要加入同步操作（即互斥锁），确保同一时刻只有一个线程在执行每次for循环中的操作。
////        synchronized (this) {
//        while (true) {
//            if (ticket > 0) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "       车票第" + ticket-- + "张");
//            } else {
//                break;
//            }
////            }
//        }
//    }
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "       车票第" + ticket-- + "张");
                }
            }
        }
    }
}
