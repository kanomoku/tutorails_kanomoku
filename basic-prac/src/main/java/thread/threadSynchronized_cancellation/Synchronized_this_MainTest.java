package thread.threadSynchronized_cancellation;

public class Synchronized_this_MainTest {
	/**
	 *
	 */
	public static void main(String[] args) {
		/**
		 * 多个线程访问同一个对象的2个不同方法，2个方法都含有synchronized (this)代码块，
		 * 1.synchronized(this)代码块则同步处理 2.synchronized (this)代码块以外的代码异步处理
		 */
//		Synchronized_this_ObjectService service = new Synchronized_this_ObjectService();
//		Synchronized_this_ThreadA a = new Synchronized_this_ThreadA(service);
//		a.setName("A");
//		a.start();
//		Synchronized_this_ThreadB b = new Synchronized_this_ThreadB(service);
//		b.setName("B");
//		b.start();
//----------------------------------------------------------------------------------------	
		/**
		 * 多个线程访问同一个对象的2个不同方法， 1个方法都含有synchronized (this)代码块， 另一个synchronized (object)
		 * 锁定的是两个对象，所以异步处理
		 */
//		Synchronized_this_ObjectService service = new Synchronized_this_ObjectService();
//		Synchronized_this_ThreadA a = new Synchronized_this_ThreadA(service);
//		a.setName("A");
//		a.start();
//		Synchronized_this_ThreadB b = new Synchronized_this_ThreadB(service);
//		b.setName("B");
//		b.start();
		// ----------------------------------------------------------------------------------------
		/**
		 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized(this) 方法，另一个为synchronized 方法，则同步处理
		 */
//		Synchronized_this_ObjectService service1 = new Synchronized_this_ObjectService();
//		Synchronized_this_ThreadD d = new Synchronized_this_ThreadD(service1);
//		d.start();
//		Synchronized_this_ThreadC c = new Synchronized_this_ThreadC(service1);
//		c.start();
		// ----------------------------------------------------------------------------------------
		/**
		 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized 方法，另一个为synchronized 方法，则同步处理
		 */
//		Synchronized_this_ObjectService service1 = new Synchronized_this_ObjectService();
//		Synchronized_this_ThreadD d = new Synchronized_this_ThreadD(service1);
//		d.start();
//		Synchronized_this_ThreadC c = new Synchronized_this_ThreadC(service1);
//		c.start();

		// ----------------------------------------------------------------------------------------
		/**
		 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized (this)部分，另一个为普通方法，则异步处理
		 */
//        Synchronized_this_ObjectService service1 = new Synchronized_this_ObjectService();
//        Synchronized_this_ThreadD d = new Synchronized_this_ThreadD(service1);
//        d.start();
//        Synchronized_this_ThreadC c = new Synchronized_this_ThreadC(service1);
//        c.start();

		/**
		 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized 方法，另一个为普通方法，则异步处理
		 */
//		Synchronized_this_ObjectService service1 = new Synchronized_this_ObjectService();
//		Synchronized_this_ThreadD d = new Synchronized_this_ThreadD(service1);
//		d.start();
//		Synchronized_this_ThreadC c = new Synchronized_this_ThreadC(service1);
//		c.start();

		// ----------------------------------------------------------------------------------------
		/**
		 * 多个线程访问不同对象，哪怕2个方法都含有synchronized (this)代码块，锁定时候的this不是同一个对象，所以异步处理
		 */
		Synchronized_this_ObjectService service = new Synchronized_this_ObjectService();
		Synchronized_this_ObjectService service2 = new Synchronized_this_ObjectService();
		Synchronized_this_ThreadA a = new Synchronized_this_ThreadA(service);
		Synchronized_this_ThreadA b = new Synchronized_this_ThreadA(service2);
		a.setName("A");
		a.start();
		b.setName("B");
		b.start();
	}
}