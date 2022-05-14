package thread.thread3Implement;

public class B_Runnable_RunningManTest {
    public static void main(String[] args) {
        //        test1();

        test2();
    }

    private static void test1() {
        B_Runnable_RunningMan r1 = new B_Runnable_RunningMan("苏炳添");
        B_Runnable_RunningMan r2 = new B_Runnable_RunningMan("博尔特");
        B_Runnable_RunningMan r3 = new B_Runnable_RunningMan("加特林");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
    }

    private static void test2() {
        B_Runnable_RunningMan r1 = new B_Runnable_RunningMan("接力");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
    }
}