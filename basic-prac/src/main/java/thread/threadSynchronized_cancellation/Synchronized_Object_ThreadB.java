package thread.threadSynchronized_cancellation;

public class Synchronized_Object_ThreadB extends Thread {
    private Synchronized_Object_ObjectService objectService;

    public Synchronized_Object_ThreadB(Synchronized_Object_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.setUserNamePassWord("b", "bb");
    }
}