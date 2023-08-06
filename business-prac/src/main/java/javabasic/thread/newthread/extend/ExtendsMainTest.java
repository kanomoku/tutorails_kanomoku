package javabasic.thread.newthread.extend;

public class ExtendsMainTest {
    public static void main(String[] args) {
        ExtendsRunningMan r1 = new ExtendsRunningMan("---------------小明---------------");
        ExtendsRunningMan r2 = new ExtendsRunningMan("-----------小张-----------");
        ExtendsRunningMan r3 = new ExtendsRunningMan("-----小李-----");
        r1.start();
        r2.start();
        r3.start();
    }
}
