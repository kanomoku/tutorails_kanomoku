package thread.threadSynchronized_cancellation;

@SuppressWarnings("all")
public class Synchronized_Class_ObjectService {
	/**
	 * 多线程访问 对象监视器为同一任务对象 synchronized(类.class) synchronized(类.class) 同步 √
	 */
	/**
	 * 多线程访问 对象监视器为同一个类的不同任务对象 synchronized(类.class) synchronized(类.class) 同步 √
	 * 
	 * @return
	 */
//    public  void methodE() {
//        try {
//            System.out.println("方法E  开始");
//            synchronized (Synchronized_Class_ObjectService.class) {
//            System.out.println("begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                Thread.sleep(1000);
//            }
//            System.out.println("end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            }
//            System.out.println("方法E  结束");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void methodF() {
//        try {
//            System.out.println("方法F  开始");
//            synchronized (Synchronized_Class_ObjectService.class) {
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                    Thread.sleep(1000);
//                }
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            }
//            System.out.println("方法F  结束");
//        } catch (
//                InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//------------------------------------------------------------------------------------------------------	
	/**
	 * 多线程访问 对象监视器为同一任务对象 synchronized(类.class) synchronized static方法 同步 √
	 */
	/**
	 * 多线程访问 对象监视器为同一个类的不同任务对象 synchronized(类.class) synchronized static方法 同步 √
	 */
//    public  synchronized static void methodE() {
//        try {
//            System.out.println("方法E  开始");
//            System.out.println("begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                Thread.sleep(1000);
//            }
//            System.out.println("end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            System.out.println("方法E  结束");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void methodF() {
//        try {
//            System.out.println("方法F  开始");
//            synchronized (Synchronized_Class_ObjectService.class) {
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                    Thread.sleep(1000);
//                }
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            }
//            System.out.println("方法F  结束");
//        } catch (
//                InterruptedException e) {
//            e.printStackTrace();
//        }
//    }	
	// ------------------------------------------------------------------------------------------------------
	/**
	 * 多线程访问 对象监视器为同一任务对象 synchronized static方法 synchronized static方法 同步 √
	 */
	/**
	 * 多线程访问 对象监视器为同一个类的不同任务对象 synchronized static方法 synchronized static方法 同步 √
	 */
//    public  synchronized static void methodE() {
//        try {
//            System.out.println("方法E  开始");
//            System.out.println("begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                Thread.sleep(1000);
//            }
//            System.out.println("end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            System.out.println("方法E  结束");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public synchronized static void methodF() {
//        try {
//            System.out.println("方法F  开始");
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                    Thread.sleep(1000);
//                }
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            System.out.println("方法F  结束");
//        } catch (
//                InterruptedException e) {
//            e.printStackTrace();
//        }
//    }		
	// ------------------------------------------------------------------------------------------------------
	/**
	 * 多线程访问  对象监视器为同一任务对象            synchronized(类.class) synchronized方法                                      异步
	 */
	/**
	 * 多线程访问  对象监视器为同一个类的不同任务对象  synchronized(类.class) synchronized方法                                      异步
	 */
	public void methodE() {
		try {
			System.out.println("方法E  开始");
			synchronized (Synchronized_Class_ObjectService.class) {
				System.out.println(
						"begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
				for (int i = 1; i <= 5; i++) {
					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
					Thread.sleep(1000);
				}
				System.out.println(
						"end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
			}
			System.out.println("方法E  结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodF() {
		try {
			System.out.println("方法F  开始");
			System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
			for (int i = 1; i <= 5; i++) {
				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
				Thread.sleep(1000);
			}
			System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
			System.out.println("方法F  结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//------------------------------------------------------------------------------------------------------	

	
//=================================================================	

	
//    //    synchronized(*.class)代码块
//    public synchronized static void methodE() {
//        try {
//            System.out.println("方法E");
////            synchronized (Synchronized_Class_ObjectService.class) {
//            System.out.println("begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                Thread.sleep(1000);
//            }
//            System.out.println("end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
////            }
//            System.out.println("方法EE");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void methodF() {
//        try {
//            System.out.println("方法F");
////            synchronized (Synchronized_Class_ObjectService.class) {
////            synchronized (this) {
////            synchronized (object) {
//            String object1 = new String();
//            synchronized (object1) {
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//                    Thread.sleep(1000);
//                }
//                System.out.println("线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
//            }
//            System.out.println("方法FF");
//        } catch (
//                InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

	// 部分静态同步synchronized方法
	public static void methodA() {
		try {
			System.out.println("方法A");
			synchronized (Synchronized_Class_ObjectService.class) {
				System.out.println("static methodA begin 线程名称:" + Thread.currentThread().getName() + " times:"
						+ System.currentTimeMillis());
				for (int i = 1; i <= 5; i++) {
					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
					Thread.sleep(1000);
				}
				System.out.println("static methodA end   线程名称:" + Thread.currentThread().getName() + " times:"
						+ System.currentTimeMillis());
			}
			System.out.println("方法AA");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	String object = new String();

	public static void methodB() {
		try {
			System.out.println("方法B");
			synchronized (Synchronized_Class_ObjectService.class) {
//            synchronized (this) {
//            synchronized (object) {
//            String object1 = new String();
//            synchronized (object1) {
				System.out.println("static methodB begin 线程名称:" + Thread.currentThread().getName() + " times:"
						+ System.currentTimeMillis());
				for (int i = 1; i <= 5; i++) {
					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
					Thread.sleep(1000);
				}
				System.out.println("static methodB end   线程名称:" + Thread.currentThread().getName() + " times:"
						+ System.currentTimeMillis());
			}
			System.out.println("方法BB");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// public synchronized static void methodC() {
	public static void methodC() {
		try {
			System.out.println("方法C");
			synchronized (Synchronized_Class_ObjectService.class) {
				System.out.println("static methodC begin 线程名称:" + Thread.currentThread().getName() + " times:"
						+ System.currentTimeMillis());
				for (int i = 1; i <= 5; i++) {
					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
					Thread.sleep(1000);
				}
				System.out.println("static methodC end   线程名称:" + Thread.currentThread().getName() + " times:"
						+ System.currentTimeMillis());
				System.out.println("方法CC");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// public synchronized static void methodD() {
//    public static void methodD() {
	public static void methodD() {
		try {
			System.out.println("方法D");
//            synchronized (Synchronized_Class_ObjectService.class) {
//            synchronized (this) {
//            synchronized (object) {
//            String object1 = new String();
//            synchronized (object1) {
			System.out.println("static methodD begin 线程名称:" + Thread.currentThread().getName() + " times:"
					+ System.currentTimeMillis());
			for (int i = 1; i <= 5; i++) {
				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
				Thread.sleep(1000);
			}
			System.out.println("static methodD end   线程名称:" + Thread.currentThread().getName() + " times:"
					+ System.currentTimeMillis());
//            }
			System.out.println("方法DD");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized static void methodG() {
		try {
			System.out.println("方法G");
			System.out.println("static method begin 线程名称:" + Thread.currentThread().getName() + " times:"
					+ System.currentTimeMillis());
			for (int i = 1; i <= 5; i++) {
				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
				Thread.sleep(1000);
			}
			System.out.println("static method end   线程名称:" + Thread.currentThread().getName() + " times:"
					+ System.currentTimeMillis());
			System.out.println("方法GG");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void methodH() {
		try {
			System.out.println("方法H");
			System.out.println("static method begin 线程名称:" + Thread.currentThread().getName() + " times:"
					+ System.currentTimeMillis());
			for (int i = 1; i <= 5; i++) {
				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
				Thread.sleep(1000);
			}
			System.out.println("static method end   线程名称:" + Thread.currentThread().getName() + " times:"
					+ System.currentTimeMillis());
			System.out.println("方法HH");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
