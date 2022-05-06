package thread.thread3Implement;

public class A_extends_RunningManTest {

    public static void main(String[] args) {
        test();
    }

    /**
     * @Test注解无法测试多线程
     */
    public static void test() {
        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + "测试开始");
        A_extends_RunningMan r1 = new A_extends_RunningMan("小明");
        A_extends_RunningMan r2 = new A_extends_RunningMan("小张");
        A_extends_RunningMan r3 = new A_extends_RunningMan("小李");
        r1.start();
        r2.start();
        r3.start();
        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + "测试结束");
    }
}