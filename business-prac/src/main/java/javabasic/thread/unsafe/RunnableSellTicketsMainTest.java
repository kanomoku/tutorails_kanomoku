package javabasic.thread.unsafe;

public class RunnableSellTicketsMainTest {
    public static void main(String[] args) {
        RunnableSellTickets myThread = new RunnableSellTickets();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }
}
