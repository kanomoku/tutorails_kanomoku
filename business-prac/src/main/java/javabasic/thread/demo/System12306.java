package javabasic.thread.demo;

import java.util.Vector;

public class System12306 {
    private final Vector<System12306Ticket> tickets = new Vector<>();

    private System12306() {
    }

    // 一个系统只能是单例模式
    private static final System12306 sys = new System12306();

    public static System12306 getInstance() {
        return sys;
    }

    // 系统创建时候就有票
    {
        for (int i = 1; i < 11; i++) {
            System12306Ticket t = new System12306Ticket("北京" + i, "深圳" + i, (i % 5 + 5) * 25F);
            tickets.add(t);
        }
    }

    // 设计一个方法从系统中取票
    public System12306Ticket getTicked() {
        try {
            return tickets.remove(0);
        } catch (Exception e) {
            return null;
        }
    }
}
