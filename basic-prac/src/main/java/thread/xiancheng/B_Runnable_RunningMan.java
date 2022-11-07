package thread.xiancheng;

public class B_Runnable_RunningMan implements Runnable {
    private String name;

    public B_Runnable_RunningMan() {
    }

    public B_Runnable_RunningMan(String name) {
        this.name = name;
    }

    //重写run方法
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            System.out.println(this.name + "跑到第" + i + "米啦");
        }
    }
}
