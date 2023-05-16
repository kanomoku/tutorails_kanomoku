package thread.lock;

public class ThreadSyn extends Thread {
    private Service service;

    public ThreadSyn(Service service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.method_syn();
    }
}
