package thread.threadSynchronized_cancellation;

public class Synchronized_Class_ThreadG extends Thread {
    private Synchronized_Class_ObjectService objectService;

    public Synchronized_Class_ThreadG() {
    }

    public Synchronized_Class_ThreadG(Synchronized_Class_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodG();
    }
}
