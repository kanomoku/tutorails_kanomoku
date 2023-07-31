package jvm;

public class JpsJmapHeap {
    public static void main(String[] args) throws InterruptedException {
        // jps → 命令找到进程id
        // jhsdb jmap --heap --pid 进程id → 查看堆情况

        System.out.println("1----");//打印1的时候看一下初始堆情况
        Thread.sleep(50000);
        byte[] bytes = new byte[1024 * 1024 * 10];//创建一个10兆的对象，会占用堆的内存
        System.out.println("2----");//打印2的时候看一下创建了对象后堆情况
        Thread.sleep(50000);
        bytes = null;
        System.gc();//垃圾回收
        System.out.println("3----");//打印3的时候看一下垃圾回收后堆情况
        Thread.sleep(50000);
    }
}
