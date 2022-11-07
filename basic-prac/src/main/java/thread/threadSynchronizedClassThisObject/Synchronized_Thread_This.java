package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_This extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread_This(Synchronized_ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod_This();
    }
}