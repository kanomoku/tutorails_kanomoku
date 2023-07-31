package thread.lock;


public class ThreadThis extends Thread {
    private Service service;

    public ThreadThis(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.method_this();
    }
}