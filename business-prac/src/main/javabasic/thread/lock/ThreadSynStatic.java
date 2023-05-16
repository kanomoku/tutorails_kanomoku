package thread.lock;


public class ThreadSynStatic extends Thread {
    private Service service;

    public ThreadSynStatic(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.method_syn_static();
    }
}