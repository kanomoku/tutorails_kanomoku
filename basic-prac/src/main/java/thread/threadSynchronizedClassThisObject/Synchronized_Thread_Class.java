package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_Class extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread_Class(Synchronized_ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod_Class();
    }
}