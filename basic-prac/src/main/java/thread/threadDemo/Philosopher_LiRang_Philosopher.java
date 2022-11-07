package thread.threadDemo;

public class Philosopher_LiRang_Philosopher extends Thread {
    private String name;
    private Philosopher_Chopstick left;
    private Philosopher_Chopstick right;
    private long time;

    public Philosopher_LiRang_Philosopher(String name, Philosopher_Chopstick left, Philosopher_Chopstick right, long time) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;
    }

    public void run(){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (left){
            System.out.println(this.name+"拿起了左手边"+this.left.getNumber() +"的筷子");
            synchronized (right){
                System.out.println(this.name+"拿起了右手边"+this.right.getNumber() +"的筷子");
                System.out.println(this.name+"就可以吃饭了");
            }
        }
    }
}
