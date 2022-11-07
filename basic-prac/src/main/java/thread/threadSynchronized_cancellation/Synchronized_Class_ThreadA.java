package thread.threadSynchronized_cancellation;

public class Synchronized_Class_ThreadA extends Thread {
    @Override
    public void run() {
        Synchronized_Class_ObjectService.methodA();
    }
}
