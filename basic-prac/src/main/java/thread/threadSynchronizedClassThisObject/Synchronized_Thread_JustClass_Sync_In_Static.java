package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_JustClass_Sync_In_Static extends Thread {
    @Override
    public void run() {
    	Synchronized_ObjectService.serviceMethod_Sync_In_static();
    }
}