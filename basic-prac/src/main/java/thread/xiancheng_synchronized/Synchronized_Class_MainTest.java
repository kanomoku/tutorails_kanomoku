package thread.xiancheng_synchronized;

/**
 *
 */
public class Synchronized_Class_MainTest {
    public static void main(String[] args) {
//        Synchronized_Class_ObjectService service = new Synchronized_Class_ObjectService();
//        Synchronized_Class_ThreadE a = new Synchronized_Class_ThreadE(service);
//        a.setName("E");
//        a.start();
//        Synchronized_Class_ThreadF b = new Synchronized_Class_ThreadF(service);
//        b.setName("F");
//        b.start();
//        上面测试方法是共同对象，下面我们分别实例化一个对象：

//        Synchronized_Class_ObjectService service1 = new Synchronized_Class_ObjectService();
//        Synchronized_Class_ObjectService service2 = new Synchronized_Class_ObjectService();
//        Synchronized_Class_ThreadE a1 = new Synchronized_Class_ThreadE(service1);
//        a1.setName("E");
//        a1.start();
//        Synchronized_Class_ThreadF b1 = new Synchronized_Class_ThreadF(service2);
//        b1.setName("F");
//        b1.start();
        /**
         * 结论：
         * 同步synchronized(*.class)代码块的作用：Class锁对类的所有对象实例起作用。
         * 多线程访问  同一对象  synchronized(Class.class) synchronized(Class.class)                             同步
         * 多线程访问  不同对象  synchronized(Class.class) synchronized(Class.class)                             同步
         * 多线程访问  同一对象  synchronized(Class.class) synchronized static方法                               同步
         * 多线程访问  不同对象  synchronized(Class.class) synchronized static方法                               同步
         * 多线程访问  同一对象  synchronized static方法   synchronized static方法                               同步
         * 多线程访问  不同对象  synchronized static方法   synchronized static方法                               同步
         * 多线程访问  同一对象  synchronized(Class.class) synchronized方法                                      异步
         * 多线程访问  同一对象  synchronized(Class.class) static方法                                            异步
         * 多线程访问  同一对象  synchronized(Class.class) 普通方法                                              异步
         * 多线程访问  同一对象  synchronized(Class.class) static synchronized(this)                             编译不过
         * 多线程访问  同一对象  synchronized(Class.class) static synchronized(object)  object在方法外面创建     编译不过
         * 多线程访问  同一对象  synchronized(Class.class) static synchronized(object)  object在方法里面创建     异步
         * 多线程访问  同一对象  synchronized(Class.class) synchronized(this)                                    异步
         * 多线程访问  同一对象  synchronized(Class.class) synchronized(object)  object在方法外面创建            异步
         * 多线程访问  同一对象  synchronized(Class.class) synchronized(object)  object在方法里面创建            异步
         * 多线程访问  同一对象  synchronized static方法   synchronized方法                                      异步
         * 多线程访问  同一对象  synchronized static方法   static方法                                            异步
         * 多线程访问  同一对象  synchronized static方法   普通方法                                              异步
         * 多线程访问  同一对象  synchronized static方法   static synchronized(this)                             编译不过
         * 多线程访问  同一对象  synchronized static方法   static synchronized(object)  object在方法外面创建     编译不过
         * 多线程访问  同一对象  synchronized static方法   static synchronized(object)  object在方法里面创建     异步
         * 多线程访问  同一对象  synchronized static方法   synchronized(this)                                    异步
         * 多线程访问  同一对象  synchronized static方法   synchronized(object)  object在方法外面创建            异步
         * 多线程访问  同一对象  synchronized static方法   synchronized(object)  object在方法里面创建            异步
         * 多线程访问  不同对象  synchronized(Class.class) synchronized方法                                      异步
         * 多线程访问  不同对象  synchronized(Class.class) static方法                                            异步
         * 多线程访问  不同对象  synchronized(Class.class) 普通方法                                              异步
         * 多线程访问  不同对象  synchronized(Class.class) static synchronized(this)                             编译不过
         * 多线程访问  不同对象  synchronized(Class.class) static synchronized(object)  object在方法外面创建     编译不过
         * 多线程访问  不同对象  synchronized(Class.class) static synchronized(object)  object在方法里面创建     异步
         * 多线程访问  不同对象  synchronized(Class.class) synchronized(this)                                    异步
         * 多线程访问  不同对象  synchronized(Class.class) synchronized(object)  object在方法外面创建            异步
         * 多线程访问  不同对象  synchronized(Class.class) synchronized(object)  object在方法里面创建            异步
         * 多线程访问  不同对象  synchronized static方法   synchronized方法                                      异步
         * 多线程访问  不同对象  synchronized static方法   static方法                                            异步
         * 多线程访问  不同对象  synchronized static方法   普通方法                                              异步
         * 多线程访问  不同对象  synchronized static方法   static synchronized(this)                             编译不过
         * 多线程访问  不同对象  synchronized static方法   static synchronized(object)  object在方法外面创建     编译不过
         * 多线程访问  不同对象  synchronized static方法   static synchronized(object)  object在方法里面创建     异步
         * 多线程访问  不同对象  synchronized static方法   synchronized(this)                                    异步
         * 多线程访问  不同对象  synchronized static方法   synchronized(object)  object在方法外面创建            异步
         * 多线程访问  不同对象  synchronized static方法   synchronized(object)  object在方法里面创建            异步
         */

//        Synchronized_Class_ObjectService service1 = new Synchronized_Class_ObjectService();
//        Synchronized_Class_ObjectService service2 = new Synchronized_Class_ObjectService();
//        Synchronized_Class_ThreadG a1 = new Synchronized_Class_ThreadG(service1);
//        a1.setName("G");
//        a1.start();
//        Synchronized_Class_ThreadH b1 = new Synchronized_Class_ThreadH(service1);
//        b1.setName("H");
//        b1.start();
        //和上面重复的例子


//        Synchronized_Class_ThreadC c = new Synchronized_Class_ThreadC();
//        c.setName("C");
//        c.start();
//        Synchronized_Class_ThreadD d = new Synchronized_Class_ThreadD();
//        d.setName("D");
//        d.start();
        /**
         *  结论：
         *  synchronized应用在static方法上，那是对当前对应的*.Class进行持锁。
         *  多线程访问  类        synchronized static                      synchronized static                                        同步
         * 多线程访问  类        synchronized static  static              synchronized(Class.class)                                  同步
         * 多线程访问  类        static synchronized(Class.class)         static synchronized(Class.class)                           同步
         * 多线程访问  类        synchronized static                      static 方法                                                异步
         * 多线程访问  类        synchronized static                      static synchronized(this)                                  编译不过
         * 多线程访问  类        synchronized static                      static synchronized(object)   object在方法外面创建         编译不过
         * 多线程访问  类        synchronized static                      static synchronized(object)   object在方法里面创建         异步
         * 多线程访问  类        static synchronized(Class.class)         static 方法                                                异步
         * 多线程访问  类        static synchronized(Class.class)         static synchronized(this)                                  编译不过
         * 多线程访问  类        static synchronized(Class.class)         static synchronized(object)   object在方法外面创建         编译不过
         * 多线程访问  类        static synchronized(Class.class)         static synchronized(object)   object在方法里面创建         异步
         */


//        Synchronized_Class_ObjectService service = new Synchronized_Class_ObjectService();
//        Synchronized_Class_ThreadA a = new Synchronized_Class_ThreadA();
//        a.setName("A");
//        a.start();
//        Synchronized_Class_ThreadB b = new Synchronized_Class_ThreadB(service);
//        b.setName("B");
//        b.start();
        /**
         * 多线程访问  类 对象   synchronized static                      synchronized(Class.class)                                  同步
         * 多线程访问  类 对象   synchronized static                      synchronized static                                        同步
         * 多线程访问  类 对象   synchronized static                      static synchronized(Class.class)                           同步
         * 多线程访问  类 对象   static synchronized(Class.class)         synchronized(Class.class)                                  同步
         * 多线程访问  类 对象   static synchronized(Class.class)         synchronized static                                        同步
         * 多线程访问  类 对象   static synchronized(Class.class)         static synchronized(Class.class)                           同步
         * 多线程访问  类 对象   synchronized static                      synchronized                                               异步
         * 多线程访问  类 对象   synchronized static                      static方法                                                 异步
         * 多线程访问  类 对象   synchronized static                      普通方法                                                   异步
         * 多线程访问  类 对象   synchronized static                      synchronized(this)                                         异步
         * 多线程访问  类 对象   synchronized static                      synchronized(object)   object在方法外面创建                异步
         * 多线程访问  类 对象   synchronized static                      synchronized(object)   object在方法里面创建                异步
         * 多线程访问  类 对象   synchronized static                      static synchronized(this)                                  编译不过
         * 多线程访问  类 对象   synchronized static                      static synchronized(object)   object在方法外面创建         编译不过
         * 多线程访问  类 对象   synchronized static                      static synchronized(object)   object在方法里面创建         异步
         * 多线程访问  类 对象   static synchronized(Class.class)         synchronized                                               异步
         * 多线程访问  类 对象   static synchronized(Class.class)         static方法                                                 异步
         * 多线程访问  类 对象   static synchronized(Class.class)         普通方法                                                   异步
         * 多线程访问  类 对象   static synchronized(Class.class)         synchronized(this)                                         异步
         * 多线程访问  类 对象   static synchronized(Class.class)         synchronized(object)   object在方法外面创建                异步
         * 多线程访问  类 对象   static synchronized(Class.class)         synchronized(object)   object在方法里面创建                异步
         * 多线程访问  类 对象   static synchronized(Class.class)         static synchronized(Class.class)                           同步
         * 多线程访问  类 对象   static synchronized(Class.class)         static synchronized(this)                                  编译不过
         * 多线程访问  类 对象   static synchronized(Class.class)         static synchronized(object)   object在方法外面创建         编译不过
         * 多线程访问  类 对象   static synchronized(Class.class)         static synchronized(object)   object在方法里面创建         异步
         * 多线程访问  类 对象   static                                   synchronized(Class.class)                                  异步
         * 多线程访问  类 对象   static                                   synchronized static                                        异步
         * 多线程访问  类 对象   static                                   synchronized                                               异步
         * 多线程访问  类 对象   static                                   static方法                                                 异步
         * 多线程访问  类 对象   static                                   普通方法                                                   异步
         * 多线程访问  类 对象   static                                   synchronized(this)                                         异步
         * 多线程访问  类 对象   static                                   synchronized(object)   object在方法外面创建                异步
         * 多线程访问  类 对象   static                                   synchronized(object)   object在方法里面创建                异步
         * 多线程访问  类 对象   static                                   static synchronized(Class.class)                           异步
         * 多线程访问  类 对象   static                                   static synchronized(this)                                  编译不过
         * 多线程访问  类 对象   static                                   static synchronized(object)   object在方法外面创建         异步
         * 多线程访问  类 对象   static                                   static synchronized(object)   object在方法里面创建         异步
         */


    }
}
