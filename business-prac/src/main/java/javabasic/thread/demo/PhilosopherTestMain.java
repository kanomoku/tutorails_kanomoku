package thread.demo;

/**
 * 哲学家就餐的例子
 * 筷子1     哲学家a     筷子2
 * 哲学家d              哲学家b
 * 筷子4     哲学家c     筷子3
 */
public class PhilosopherTestMain {
    public static void main(String[] args) {
        deadlock();
        notDeadLock();
    }

    private static void notDeadLock() {
        // 要礼让,产生一个时间差
        // 不要产生对象共有的问题
        PhilosopherChopstick c1 = new PhilosopherChopstick(1);
        PhilosopherChopstick c2 = new PhilosopherChopstick(2);
        PhilosopherChopstick c3 = new PhilosopherChopstick(3);
        PhilosopherChopstick c4 = new PhilosopherChopstick(4);
        PhilosopherPhilosopherWait p1 = new PhilosopherPhilosopherWait("哲学家a", c2, c1, 0);
        PhilosopherPhilosopherWait p2 = new PhilosopherPhilosopherWait("哲学家b", c3, c2, 3000);
        PhilosopherPhilosopherWait p3 = new PhilosopherPhilosopherWait("哲学家c", c4, c3, 6000);
        PhilosopherPhilosopherWait p4 = new PhilosopherPhilosopherWait("哲学家d", c1, c4, 9000);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

    private static void deadlock() {
        PhilosopherChopstick chopstick1 = new PhilosopherChopstick(1);
        PhilosopherChopstick chopstick2 = new PhilosopherChopstick(2);
        PhilosopherChopstick chopstick3 = new PhilosopherChopstick(3);
        PhilosopherChopstick chopstick4 = new PhilosopherChopstick(4);
        PhilosopherPhilosopher p1 = new PhilosopherPhilosopher("哲学家a", chopstick2, chopstick1);
        PhilosopherPhilosopher p2 = new PhilosopherPhilosopher("哲学家b", chopstick3, chopstick2);
        PhilosopherPhilosopher p3 = new PhilosopherPhilosopher("哲学家c", chopstick4, chopstick3);
        PhilosopherPhilosopher p4 = new PhilosopherPhilosopher("哲学家d", chopstick1, chopstick4);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}

