package thread.threadSynchronized_cancellation;

public class Synchronized_Class_ThreadF extends Thread {
    private Synchronized_Class_ObjectService objectService;

    public Synchronized_Class_ThreadF() {
    }

    public Synchronized_Class_ThreadF(Synchronized_Class_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodF();
    }
}
