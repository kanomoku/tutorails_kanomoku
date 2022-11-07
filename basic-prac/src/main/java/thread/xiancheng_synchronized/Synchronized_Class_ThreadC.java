package thread.xiancheng_synchronized;

public class Synchronized_Class_ThreadC extends Thread {

    @Override
    public void run() {
        Synchronized_Class_ObjectService.methodC();
    }
}
