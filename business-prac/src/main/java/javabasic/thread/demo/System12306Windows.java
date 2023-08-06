package javabasic.thread.demo;

public class System12306Windows extends Thread {
    private String name;

    public System12306Windows(String windowName) {
        this.name = windowName;
    }

    public void run() {
        this.sellTicket();
    }

    public void sellTicket() {
        while (true) {
            System12306 sys = System12306.getInstance();
            System12306Ticket ticket = sys.getTicked();
            if (ticket == null) {
                System.out.println("对不起" + name + "票卖光了");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " 从" + name + "售出 " + ticket);
        }
    }
}
