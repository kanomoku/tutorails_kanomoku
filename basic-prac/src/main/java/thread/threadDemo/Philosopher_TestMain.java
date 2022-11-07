package thread.threadDemo;

/**
 * 哲学家就餐的例子
 * 筷子1     哲学家a     筷子2
 * 哲学家d          哲学家b
 * 筷子4     哲学家c     筷子3
 */
public class Philosopher_TestMain {
    public static void main(String[] args) {
        Philosopher_Chopstick c1 = new Philosopher_Chopstick(1);
        Philosopher_Chopstick c2 = new Philosopher_Chopstick(2);
        Philosopher_Chopstick c3 = new Philosopher_Chopstick(3);
        Philosopher_Chopstick c4 = new Philosopher_Chopstick(4);
        Philosopher_Philosopher p1 = new Philosopher_Philosopher("哲学家a", c2, c1);
        Philosopher_Philosopher p2 = new Philosopher_Philosopher("哲学家b", c3, c2);
        Philosopher_Philosopher p3 = new Philosopher_Philosopher("哲学家c", c4, c3);
        Philosopher_Philosopher p4 = new Philosopher_Philosopher("哲学家d", c1, c4);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
//线程1  先拿a 再拿b
//线程2  先拿b 再拿a
//线程1拿了a--线程2拿了b--线程1发现b没了又不舍得舍弃a--线程2发现a没了又不舍的放弃b--于是就死锁了
//哲学家就餐的例子
//   筷子1     哲学家a     筷子2
//   哲学家d               哲学家b
//   筷子4     哲学家c     筷子3   


//有可能会产生一个死锁的状态
