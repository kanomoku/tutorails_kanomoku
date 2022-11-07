package thread.threadDemo;

public class A_extends_System12306_Windows extends Thread {
	private String widowName;

	public A_extends_System12306_Windows() {
	}

	public A_extends_System12306_Windows(String windowName) {
		this.widowName = windowName;
	}

	public void run() {
		this.sellTicket();
	}

	public void sellTicket() {
		while (true) {
			A_extends_System12306 sys = A_extends_System12306.getInstance();
			A_extends_System12306_Ticket ticket = sys.getTicked();
			if (ticket == null) {
				System.out.println("对不起" + widowName + "票卖光了");
				break;
			}
			System.out.println(Thread.currentThread().getName() + "从" + widowName + "售出" + ticket.toString());
		}
	}
}
