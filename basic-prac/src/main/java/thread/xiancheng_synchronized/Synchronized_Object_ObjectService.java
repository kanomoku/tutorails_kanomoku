package thread.xiancheng_synchronized;

public class Synchronized_Object_ObjectService {
    private String uname;
    private String pwd;

    //将任意对象作为对象监视器
    String lock = new String();

    public void setUserNamePassWord(String userName, String passWord) {
        try {
            System.out.println(Thread.currentThread().getName() + "方法开始");
            synchronized (lock) {
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis());
                uname = userName;
                for (int i = 1; i <= 5; i++) {
                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
                pwd = passWord;
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis() + "入参uname:" + uname + "入参pwd:" + pwd);
            }
            System.out.println(Thread.currentThread().getName() + "方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //锁定同一个对象，同步执行

//    //    下面我把String lock=new String();放在方法中会有啥结果了：
//    public void setUserNamePassWord(String userName, String passWord) {
//        try {
//            System.out.println(Thread.currentThread().getName() + "方法开始");
//            String lock = new String();
//            synchronized (lock) {
//                System.out.println("thread name=" + Thread.currentThread().getName()
//                        + " 进入代码快:" + System.currentTimeMillis());
//                uname = userName;
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                    Thread.sleep(1000);
//                }
//                pwd = passWord;
//                System.out.println("thread name=" + Thread.currentThread().getName()
//                        + " 进入代码快:" + System.currentTimeMillis() + "入参uname:" + uname + "入参pwd:" + pwd);
//            }
//            System.out.println(Thread.currentThread().getName() + "方法结束");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    //锁定的不是同一个对象，是异步执行

//    结论：
//    多个线程持有对象监视器作为同一个对象的前提下，同一时间只有一个线程可以执行synchronized(任意自定义对象)同步代码快。


    //    synchronized(任意自定义对象)与synchronized同步方法共用
    private String lock1 = new String();

    public void methodC() {
        try {
            System.out.println(Thread.currentThread().getName() + "方法开始");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " begin");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + "   end");
            }
            System.out.println(Thread.currentThread().getName() + "方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public synchronized void methodD() {
    public void methodD() {
        try {
            System.out.println(Thread.currentThread().getName() + "方法开始");
            System.out.println(Thread.currentThread().getName() + "   begin");
            for (int i = 1; i <= 5; i++) {
                System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + "     end");
            System.out.println(Thread.currentThread().getName() + "方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    结论：
//    使用synchronized(任意自定义对象)进行同步操作，对象监视器必须是同一个对象。如果不是同一个，运行就是异步执行了。


}