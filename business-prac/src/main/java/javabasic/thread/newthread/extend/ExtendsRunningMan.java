package thread.newthread.extend;

/**
 * @author Administrator
 */
public class ExtendsRunningMan extends Thread {
    private String name;

    public ExtendsRunningMan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + name + i);
        }
    }
}