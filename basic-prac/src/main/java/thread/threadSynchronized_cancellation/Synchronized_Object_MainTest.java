package thread.threadSynchronized_cancellation;

public class Synchronized_Object_MainTest {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 多个线程访问同一个对象的同一个synchronized (object1)修饰的方法，object1为同一个对象， 锁定用一个对象，则同步处理
		 */
//        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ThreadA a = new Synchronized_Object_ThreadA(service);
//        a.setName("A");
//        a.start();
//        Synchronized_Object_ThreadB b = new Synchronized_Object_ThreadB(service);
//        b.setName("B");
//        b.start();
		// ------------------------------------------------------------------------------------------------
		/**
		 * 多个线程访问同一个对象的同一个synchronized (object)修饰的方法，object为不同对象， 锁定不同对象，则异步处理
		 */
//        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ThreadA a = new Synchronized_Object_ThreadA(service);
//        a.setName("A");
//        a.start();
//        Synchronized_Object_ThreadB b = new Synchronized_Object_ThreadB(service);
//        b.setName("B");
//        b.start();
		// ------------------------------------------------------------------------------------------------
		/**
		 * 多个线程访问同一个对象的2个不同方法，一个方法synchronized (object1) 另一个synchronized方法，锁定不同对象，则异步处理
		 */
//      Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//      Synchronized_Object_ThreadC a = new Synchronized_Object_ThreadC(service);
//      a.setName("C");
//      a.start();
//      Synchronized_Object_ThreadD b = new Synchronized_Object_ThreadD(service);
//      b.setName("D");
//      b.start();
		// ------------------------------------------------------------------------------------------------
		/**
		 * 多个线程访问同一个对象的2个不同方法，一个方法synchronized (object1) 另一个方法普通方法，锁定用不同对象，则异步处理
		 */
//		Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//		Synchronized_Object_ThreadC a = new Synchronized_Object_ThreadC(service);
//		a.setName("C");
//		a.start();
//		Synchronized_Object_ThreadD b = new Synchronized_Object_ThreadD(service);
//		b.setName("D");
//		b.start();
		// ------------------------------------------------------------------------------------------------
		/**
		 * 多个线程访问不同对象的同一个synchronized (object1)修饰的方法，object1为同一个对象， 锁定不同对象，则异步处理
		 */
//        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ObjectService service2 = new Synchronized_Object_ObjectService();
//        Synchronized_Object_ThreadA a = new Synchronized_Object_ThreadA(service);
//        a.setName("A");
//        a.start();
//        Synchronized_Object_ThreadB b = new Synchronized_Object_ThreadB(service2);
//        b.setName("B");
//        b.start();
        // ------------------------------------------------------------------------------------------------
        /**
         * 多个线程访问不同对象的同一个synchronized (object)修饰的方法，object为不同对象， 锁定不同对象，则异步处理
         */
        Synchronized_Object_ObjectService service = new Synchronized_Object_ObjectService();
        Synchronized_Object_ObjectService service2 = new Synchronized_Object_ObjectService();
        Synchronized_Object_ThreadA a = new Synchronized_Object_ThreadA(service);
        a.setName("A");
        a.start();
        Synchronized_Object_ThreadB b = new Synchronized_Object_ThreadB(service2);
        b.setName("B");
        b.start();

	}
}