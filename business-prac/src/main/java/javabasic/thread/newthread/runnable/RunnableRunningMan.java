package javabasic.thread.newthread.runnable;

public class RunnableRunningMan implements Runnable {
    private String name;

    public RunnableRunningMan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + name + " " + i);
        }
    }
}
