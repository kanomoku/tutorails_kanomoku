package thread.xiancheng_synchronized;

public class Synchronized_Object_MainTest {
    public static void main(String[] args) throws InterruptedException {
//        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ThreadA a = new Synchronized_Object_ThreadA(service);
//        a.setName("A");
//        a.start();
//        Synchronized_Object_ThreadB b = new Synchronized_Object_ThreadB(service);
//        b.setName("B");
//        b.start();
        /**
         *  多个线程访问同一个对象的2个不同方法，一个方法synchronized (object1) 另一个方法synchronized (object1)，
         *  锁定用一个对象，则同步处理
         */
        /**
         *  多个线程访问同一个对象的2个不同方法，一个方法synchronized (object1) 另一个方法synchronized (object2)，
         *  锁定用不同对象，则异步处理
         */
        //多个线程持有对象监视器作为同一个对象的前提下，同一时间只有一个线程可以执行synchronized(任意自定义对象)同步代码快。


//        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ObjectService service1 = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ThreadA a = new Synchronized_Object_ThreadA(service);
//        a.setName("A");
//        a.start();
//        Synchronized_Object_ThreadB b = new Synchronized_Object_ThreadB(service1);
//        b.setName("B");
//        b.start();
        /**
         *  多个线程访问的是不同的对象，
         *  不管，一个方法synchronized (object1) 另一个方法synchronized (object1)，
         *  还是，一个方法synchronized (object1) 另一个方法synchronized (object2)，
         *  锁定的不是同一个对象，自然异步处理
         */
        //多个线程调用不是同一个对象，锁定的自然不是同一个对象，异步执行

        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
        Synchronized_Object_ThreadC a = new Synchronized_Object_ThreadC(service);
        a.setName("C");
        a.start();
        Synchronized_Object_ThreadD b = new Synchronized_Object_ThreadD(service);
        b.setName("D");
        b.start();
        /**
         *  和上面本质一样，多个线程调用不是同一个对象，锁定的自然不是同一个对象，异步执行
         */
        //使用synchronized(任意自定义对象)进行同步操作，对象监视器必须是同一个对象。如果不是同一个，运行就是异步执行了。

    }
}