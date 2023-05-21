package thread.demo;

public class PhilosopherPhilosopherWait extends Thread {
    private String name;
    private PhilosopherChopstick left;
    private PhilosopherChopstick right;
    private long time;

    public PhilosopherPhilosopherWait(String name, PhilosopherChopstick left, PhilosopherChopstick right, long time) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;
    }

    public void run() {
        waitMs();
        synchronized (left) {
            System.out.println(this.name + " 拿起了左手边 " + this.left.getNumber() + " 的筷子");
            synchronized (right) {
                System.out.println(this.name + " 拿起了右手边 " + this.right.getNumber() + " 的筷子");
                System.out.println(this.name + " 就可以吃饭了");
            }
        }
    }

    private void waitMs() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
