package thread.threadDemo;

public class A_extends_System12306_MainTest {
    public static void main(String[] args) {
        A_extends_System12306_Windows w1 = new A_extends_System12306_Windows("北京北站");
        A_extends_System12306_Windows w2 = new A_extends_System12306_Windows("北京南站");
        A_extends_System12306_Windows w3 = new A_extends_System12306_Windows("北京西站");
        w1.start();
        w2.start();
        w3.start();
    }
}