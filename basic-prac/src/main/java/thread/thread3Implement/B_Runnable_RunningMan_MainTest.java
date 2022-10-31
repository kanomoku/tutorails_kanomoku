package thread.thread3Implement;

public class B_Runnable_RunningMan_MainTest {
    public static void main(String[] args) {
        // threeThreadDoThreeThing();

        threeThreadDoOneThing();
    }

    private static void threeThreadDoOneThing() {
        B_Runnable_RunningMan r1 = new B_Runnable_RunningMan("苏炳添");
//        B_Runnable_RunningMan r2 = new B_Runnable_RunningMan("博尔特");
//        B_Runnable_RunningMan r3 = new B_Runnable_RunningMan("加特林");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
    }

    private static void threeThreadDoThreeThing() {
        // 背景介绍(zzw)2022/10/31:三个线程做三件事
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
}
