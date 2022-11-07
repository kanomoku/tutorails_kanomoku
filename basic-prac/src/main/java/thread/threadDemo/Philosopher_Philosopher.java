package thread.threadDemo;

public class Philosopher_Philosopher extends Thread {
    private String name;
    private Philosopher_Chopstick left;
    private Philosopher_Chopstick right;

    public Philosopher_Philosopher(String name, Philosopher_Chopstick left, Philosopher_Chopstick right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public void run() {
        synchronized (left) {
            System.out.println(this.name + " 拿起了左手边 " + this.left.getNumber() + " 的筷子");
            synchronized (right) {
                System.out.println(this.name + " 拿起了右手边 " + this.right.getNumber() + " 的筷子");
                System.out.println(this.name + " 就可以吃饭了 ");
            }
        }
    }
}
