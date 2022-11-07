package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_Sync_In_Static2 extends Thread {
    private Synchronized_ObjectService objectService;

    public Synchronized_Thread_Sync_In_Static2(Synchronized_ObjectService objectService) {
        this.objectService = objectService;
    }
    @Override
    public void run() {
    	objectService.serviceMethod_Sync_In_static2();
    }
}