package thread.threadSynchronized_cancellation;

public class Synchronized_Class_ThreadB extends Thread {
    private Synchronized_Class_ObjectService objectService;

    public Synchronized_Class_ThreadB(Synchronized_Class_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodB();
    }
}
