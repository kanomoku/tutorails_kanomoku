package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_Object extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread_Object(Synchronized_ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod_Object();
    }
}