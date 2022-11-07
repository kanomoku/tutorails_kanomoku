package thread.xiancheng;

public class A_extends_RunningMan extends Thread {
    private String name;

    public A_extends_RunningMan() {
    }

    public A_extends_RunningMan(String name) {
        this.name = name;
    }

    // 重写run方法
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + this.name + "跑到第" + i + "米啦");
        }
    }
}