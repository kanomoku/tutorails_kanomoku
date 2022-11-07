package thread.threadSynchronized_cancellation;

public class Synchronized_this_ThreadC extends Thread {
    private Synchronized_this_ObjectService objectService;

    public Synchronized_this_ThreadC(Synchronized_this_ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethodC();
    }
}