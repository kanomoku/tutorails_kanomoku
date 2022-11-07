package thread.threadDemo;

import java.util.Vector;

public class A_extends_System12306 {
    // 一个系统只能是单例模式
    private A_extends_System12306() {
    }

    private static A_extends_System12306 sys = new A_extends_System12306();

    public static A_extends_System12306 getInstance() {
        return sys;
    }

    //利用Vector集合--集合本身就是线程安全
    private Vector<A_extends_System12306_Ticket> tickets = new Vector<>();
    // 系统创建时候就有票
    {
        for (int i = 10; i < 100; i++) {
            A_extends_System12306_Ticket t = new A_extends_System12306_Ticket("北京" + i, "深圳" + i, (i % 5 + 5) * 25F);
            System.out.println(t.toString());
            tickets.add(t);
        }
    }

    // 设计一个方法从系统中取票
    public A_extends_System12306_Ticket getTicked() {
        try {
            return tickets.remove(0);
        } catch (Exception e) {
            return null;
        }
    }
}
