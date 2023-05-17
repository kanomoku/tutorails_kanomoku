package thread.newthread.runnable;

import thread.newthread.extend.ExtendsRunningMan;

public class RunningManMainTest {
    public static void main(String[] args) {
         threeThreadDoThreeThing();

//        threeThreadDoOneThing();
    }

    private static void threeThreadDoOneThing() {
        RunnableRunningMan r1 = new RunnableRunningMan("小明");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
    }

    private static void threeThreadDoThreeThing() {
        RunnableRunningMan r1 = new RunnableRunningMan("---------------小明---------------");
        RunnableRunningMan r2 = new RunnableRunningMan("-----------小张-----------");
        RunnableRunningMan r3 = new RunnableRunningMan("-----小李-----");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
    }
}
