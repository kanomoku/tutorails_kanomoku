package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_Sync_In_Static extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread_Sync_In_Static(Synchronized_ObjectService objectService) {
        this.objectService = objectService;
    }
    @Override
    public void run() {
    	objectService.serviceMethod_Sync_In_static();
    }
}