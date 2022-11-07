package thread.threadSynchronized_cancellation;

//美 [ˈsɪŋkrənaɪzd]  (使) 同步，在时间上一致，同速进行;
public class Synchronized_this_ObjectService {
	String lock = new String();

	/**
	 * 多个线程访问同一个对象的2个不同方法，2个方法都含有synchronized (this)代码块，
	 * 1.synchronized(this)代码块则同步处理 2.synchronized (this)代码块以外的代码异步处理
	 */
    public void serviceMethodA() {
        try {
            System.out.println("方法A Start");
            synchronized (this) {
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
	// ----------------------------------------------------------------------------------------
	/**
	 * 多个线程访问同一个对象的2个不同方法， 1个方法都含有synchronized (this)代码块， 另一个synchronized (object)
	 * 锁定的是两个对象，所以异步处理
	 */

//	public void serviceMethodA() {
//		try {
//			System.out.println("方法A Start");
//			synchronized (lock) {
//				System.out.println(
//						"线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
//				Thread.sleep(2000);
//				System.out.println(
//						"线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
//			}
//			System.out.println("方法A End");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	public void serviceMethodB() {
//		System.out.println("方法B  Start");
//		synchronized (this) {
//			System.out.println(
//					"线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
//			System.out
//					.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
//		}
//		System.out.println("方法B End");
//	}
	// ----------------------------------------------------------------------------------------

	/**
	 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized(this) 方法，另一个为synchronized 方法，则同步处理
	 */
	public synchronized void serviceMethodC() {
		System.out.println("方法C Start");
		for (int i = 1; i <= 5; i++) {
			System.out.println(" thread name:" + Thread.currentThread().getName() + "-->i=" + i);
		}
		System.out.println("方法C End");
	}

	public void serviceMethodD() {
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
	// ----------------------------------------------------------------------------------------
	/**
	 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized 方法，另一个为synchronized 方法，则同步处理
	 */
//	public synchronized void serviceMethodC() {
//		System.out.println("方法C Start");
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(" thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//		}
//		System.out.println("方法C End");
//	}
//
//	public synchronized void serviceMethodD() {
//		System.out.println("方法D  Start");
//		try {
//			for (int i = 1; i <= 5; i++) {
//				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("方法D End");
//	}

	// ----------------------------------------------------------------------------------------
	/**
	 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized (this)部分，另一个为普通方法，则异步处理
	 */
//	public void serviceMethodC() {
//		System.out.println("方法C Start");
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(" thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//		}
//		System.out.println("方法C End");
//	}
//
//	public void serviceMethodD() {
//		System.out.println("方法D  Start");
//		synchronized (this) {
//			try {
//				for (int i = 1; i <= 5; i++) {
//					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//					Thread.sleep(1000);
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("方法D End");
//	}

	/**
	 * 多个线程访问同一个对象的2个不同方法，一个方法包含synchronized 方法，另一个为普通方法，则异步处理
	 */
//	public void serviceMethodC() {
//		System.out.println("方法C Start");
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(" thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//		}
//		System.out.println("方法C End");
//	}
//
//	public synchronized void serviceMethodD() {
//		System.out.println("方法D  Start");
//		try {
//			for (int i = 1; i <= 5; i++) {
//				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("方法D End");
//	}
	// ----------------------------------------------------------------------------------------
	/**
	 * 多个线程访问不同对象，哪怕2个方法都含有synchronized (this)代码块，锁定时候的this不是同一个对象，所以异步处理
	 */
//  public void serviceMethodA() {
//  try {
//            System.out.println("方法A Start");
//            synchronized (this) {
//                System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
//                Thread.sleep(2000);
//                System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
//            }
//            System.out.println("方法A End");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void serviceMethodB() {
//        System.out.println("方法B  Start");
//        synchronized (this) {
//            System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
//            System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
//        }
//        System.out.println("方法B End");
//    }
}