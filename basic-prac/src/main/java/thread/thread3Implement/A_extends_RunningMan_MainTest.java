package thread.thread3Implement;

public class A_extends_RunningMan_MainTest {
    public static void main(String[] args) {
        A_extends_RunningMan r1 = new A_extends_RunningMan("小明");
        A_extends_RunningMan r2 = new A_extends_RunningMan("小张");
        A_extends_RunningMan r3 = new A_extends_RunningMan("小李");
        r1.start();
        r2.start();
        r3.start();
    }
}
