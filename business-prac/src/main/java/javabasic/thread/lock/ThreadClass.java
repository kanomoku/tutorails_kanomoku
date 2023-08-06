package javabasic.thread.lock;

public class ThreadClass extends Thread {
    private Service service;

    public ThreadClass(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.method_class();
    }
}