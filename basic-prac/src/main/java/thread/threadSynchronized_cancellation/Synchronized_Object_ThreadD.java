package thread.threadSynchronized_cancellation;

public class Synchronized_Object_ThreadD extends Thread {
    private Synchronized_Object_ObjectService objectService;

    public Synchronized_Object_ThreadD(Synchronized_Object_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodD();
    }
}
