package thread.thread3Implement;

public class B_Runnable_RunningMan implements Runnable {
    private String name;

    public B_Runnable_RunningMan() {
    }

    public B_Runnable_RunningMan(String name) {
        this.name = name;
    }

    //重写run方法
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + this.name + "跑到第" + i + "米啦");
        }
    }
}
