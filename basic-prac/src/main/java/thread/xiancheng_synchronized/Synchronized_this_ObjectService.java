package thread.xiancheng_synchronized;

//美 [ˈsɪŋkrənaɪzd]  (使) 同步，在时间上一致，同速进行;
public class Synchronized_this_ObjectService {
    String lock = new String();

    //synchronized代码块间的同步性
    public void serviceMethodA() {
        try {
            System.out.println("方法A Start");
//            synchronized (this) {
            synchronized (lock) {
                System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
            }
            System.out.println("方法A End");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        System.out.println("方法B  Start");
        synchronized (this) {
            System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
            System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
        }
        System.out.println("方法B End");
    }
//    当一个线程访问ObjectService的一个synchronized (this)同步代码块时，
//    其它线程对同一个ObjectService中其它的synchronized (this)同步代码块的访问将是堵塞，
//    这说明synchronized (this)使用的对象监视器是一个。

    //    验证synchronized (this)代码块是锁定当前对象
//    public void serviceMethodC() {//可以看到objectMethodA方法异步执行了，下面我们将objectMethodA()加上同步。

    public synchronized void serviceMethodC() {
//    public  void serviceMethodC() {
        System.out.println("方法C Start");
        System.out.println("run----objectMethodC");
        System.out.println("方法C End");
    }


    public synchronized void serviceMethodD() {
//    public void serviceMethodD() {
        System.out.println("方法D  Start");
        synchronized (this) {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("方法D End");
    }
//    结论：
//    上面三个小例子我们可以知道，
//    多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时，是同步的。
//            1、synchronized同步方法
//            2、synchronized(this)同步代码块
//同一时间只有一个线程执行synchronized同步方法或者或synchronized(this)同步代码块中的代码，
// 对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
// 对于不是synchronized同步方法或synchronized(this)同步代码块则是异步的。

}