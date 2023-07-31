package thread.lock;

public class ThreadLocLock extends Thread {
    private Service service;

    public ThreadLocLock(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.method_loc_lock();
    }
}