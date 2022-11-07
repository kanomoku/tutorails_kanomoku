package thread.threadDemo;

/**
 * 解决死锁的问题
 * 1.要礼让----->产生一个时间差
 * 2.不要产生对象共有的问题
 * <p>
 * 礼让方法来一个
 */
public class Philosopher_LiRang_TestMain {
    public static void main(String[] args) {
        Philosopher_Chopstick c1 = new Philosopher_Chopstick(1);
        Philosopher_Chopstick c2 = new Philosopher_Chopstick(2);
        Philosopher_Chopstick c3 = new Philosopher_Chopstick(3);
        Philosopher_Chopstick c4 = new Philosopher_Chopstick(4);
        Philosopher_LiRang_Philosopher p1 = new Philosopher_LiRang_Philosopher("哲学家a", c2, c1, 0);
        Philosopher_LiRang_Philosopher p2 = new Philosopher_LiRang_Philosopher("哲学家b", c3, c2, 3000);
        Philosopher_LiRang_Philosopher p3 = new Philosopher_LiRang_Philosopher("哲学家c", c4, c3, 6000);
        Philosopher_LiRang_Philosopher p4 = new Philosopher_LiRang_Philosopher("哲学家d", c1, c4, 9000);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
