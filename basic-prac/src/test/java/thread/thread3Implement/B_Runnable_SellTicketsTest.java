package thread.thread3Implement;

public class B_Runnable_SellTicketsTest {
    public static void main(String[] args) {
        test1();

        //        test2();
    }

    private static void test1() {
        B_Runnable_SellTickets myThread1 = new B_Runnable_SellTickets();
        B_Runnable_SellTickets myThread2 = new B_Runnable_SellTickets();
        new Thread(myThread1).start();
        new Thread(myThread2).start();
    }

    private static void test2() {
        B_Runnable_SellTickets myThread = new B_Runnable_SellTickets();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }
}