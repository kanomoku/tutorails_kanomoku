package thread.thread3Implement;

/**
 * @author Administrator
 */
public class A_extends_RunningMan extends Thread {
    private String threadTaskName;

    public A_extends_RunningMan() {
    }

    public A_extends_RunningMan(String name) {
        this.threadTaskName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getId() +" "+ Thread.currentThread().getName() +" "+ this.threadTaskName
                + " 跑到第" + i + "米啦");
        }
    }
}