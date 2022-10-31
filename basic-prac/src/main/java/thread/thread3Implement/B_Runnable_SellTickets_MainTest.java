package thread.thread3Implement;

public class B_Runnable_SellTickets_MainTest {
    public static void main(String[] args) {
        B_Runnable_SellTickets myThread = new B_Runnable_SellTickets();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();

//        B_Runnable_SellTickets myThread1 = new B_Runnable_SellTickets();
//        B_Runnable_SellTickets myThread2 = new B_Runnable_SellTickets();
//        new Thread(myThread1).start();
//        new Thread(myThread2).start();
    }
}
