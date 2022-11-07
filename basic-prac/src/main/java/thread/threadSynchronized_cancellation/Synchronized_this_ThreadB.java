package thread.threadSynchronized_cancellation;


public class Synchronized_this_ThreadB extends Thread {
    private Synchronized_this_ObjectService objectService;

    public Synchronized_this_ThreadB(Synchronized_this_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethodB();
    }
}