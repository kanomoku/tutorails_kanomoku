package thread.thread3Implement;

public class A_extends_SellTickets extends Thread {

    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "     车票第" + ticket-- + "张");
            } else {
                break;
            }
        }
    }
}
