package jvm;

public class Xmn {
    public static void main(String[] args) throws InterruptedException {
        // jps → 命令找到进程id
        // jhsdb jmap --heap --pid 进程id → 查看堆情况
        Thread.sleep(90000);
    }
}
