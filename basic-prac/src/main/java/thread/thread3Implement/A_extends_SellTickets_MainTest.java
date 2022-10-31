package thread.thread3Implement;

public class A_extends_SellTickets_MainTest {
    public static void main(String[] args) {
        A_extends_SellTickets t1 = new A_extends_SellTickets();
        t1.setName("线程1");
        t1.start();
        A_extends_SellTickets t2 = new A_extends_SellTickets();
        t2.setName("线程2");
        t2.start();
        A_extends_SellTickets t3 = new A_extends_SellTickets();
        t3.setName("线程3");
        t3.start();
    }
}
