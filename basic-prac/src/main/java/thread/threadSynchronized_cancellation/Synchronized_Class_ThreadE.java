package thread.threadSynchronized_cancellation;

public class Synchronized_Class_ThreadE extends Thread {
    private Synchronized_Class_ObjectService objectService;

    public Synchronized_Class_ThreadE() {
    }

    public Synchronized_Class_ThreadE(Synchronized_Class_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodE();
    }
}
