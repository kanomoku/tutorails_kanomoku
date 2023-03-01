package thread.pool;

import java.util.Date;

public class threadPool1_Handle implements Runnable {
    private String name;

    public threadPool1_Handle(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "~~" + name + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "~~" + name + " End   Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
