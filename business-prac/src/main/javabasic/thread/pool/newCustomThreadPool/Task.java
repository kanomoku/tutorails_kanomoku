package thread.pool.newCustomThreadPool;

import java.util.Date;

public class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " → " + name + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " → " + name + " End   Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
