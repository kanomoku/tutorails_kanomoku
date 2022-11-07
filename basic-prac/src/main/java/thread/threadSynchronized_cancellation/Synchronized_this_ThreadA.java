package thread.threadSynchronized_cancellation;

public class Synchronized_this_ThreadA extends Thread {
    private Synchronized_this_ObjectService objectService;

    public Synchronized_this_ThreadA(Synchronized_this_ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethodA();
    }
}