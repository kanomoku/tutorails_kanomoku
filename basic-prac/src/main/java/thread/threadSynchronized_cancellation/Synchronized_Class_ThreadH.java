package thread.threadSynchronized_cancellation;

public class Synchronized_Class_ThreadH extends Thread {
    private Synchronized_Class_ObjectService objectService;

    public Synchronized_Class_ThreadH() {
    }

    public Synchronized_Class_ThreadH(Synchronized_Class_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodH();
    }
}
