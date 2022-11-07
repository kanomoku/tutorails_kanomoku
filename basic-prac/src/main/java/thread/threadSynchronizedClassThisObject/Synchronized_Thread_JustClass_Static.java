package thread.threadSynchronizedClassThisObject;

public class Synchronized_Thread_JustClass_Static extends Thread {
    @Override
    public void run() {
    	Synchronized_ObjectService.serviceMethod3();
    }
}