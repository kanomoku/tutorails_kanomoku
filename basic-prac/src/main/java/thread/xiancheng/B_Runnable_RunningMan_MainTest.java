package thread.xiancheng;

public class B_Runnable_RunningMan_MainTest {
    public static void main(String[] args) {
//        B_implements_RunningMan r1 = new B_implements_RunningMan("苏炳添");
//        B_implements_RunningMan r2 = new B_implements_RunningMan("博尔特");
//        B_implements_RunningMan r3 = new B_implements_RunningMan("加特林");
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        Thread t3 = new Thread(r3);
//        t1.start();
//        t2.start();
//        t3.start();

        B_Runnable_RunningMan r1 = new B_Runnable_RunningMan("苏炳添");
//        B_implements_RunningMan r2 = new B_implements_RunningMan("博尔特");
//        B_implements_RunningMan r3 = new B_implements_RunningMan("加特林");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
    }
}
