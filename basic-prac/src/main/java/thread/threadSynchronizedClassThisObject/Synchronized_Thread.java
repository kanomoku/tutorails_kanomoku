package thread.threadSynchronizedClassThisObject;


public class Synchronized_Thread extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread(Synchronized_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.serviceMethod();
    }
}