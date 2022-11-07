package thread.xiancheng_xianchengchi;

import java.util.Date;
/**
 * 功能概要：缓冲线程池实例-execute运行
 *
 */
public class XiChengChi_Handle implements Runnable {
    private String name;

    public XiChengChi_Handle(String name) {
        this.name = "thread " + name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + name + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + name + " End Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

}
