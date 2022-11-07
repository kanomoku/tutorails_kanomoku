package thread.threadSynchronizedClassThisObject;


public class Synchronized_Thread2 extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread2(Synchronized_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod2();
    }
}