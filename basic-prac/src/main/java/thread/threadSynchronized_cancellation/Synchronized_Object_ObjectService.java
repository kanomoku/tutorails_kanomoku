package thread.threadSynchronized_cancellation;

public class Synchronized_Object_ObjectService {
	private String uname;
	private String pwd;

	// 将任意对象作为对象监视器
	String lock = new String();
	/**
	 * 多个线程访问同一个对象的同一个synchronized (object1)修饰的方法，object1为同一个对象， 锁定用一个对象，则同步处理
	 */
//    public void setUserNamePassWord(String userName, String passWord) {
//        try {
//            System.out.println(Thread.currentThread().getName() + "方法开始");
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
//------------------------------------------------------------------------------------------------
	/**
	 * 多个线程访问同一个对象的同一个synchronized (object)修饰的方法，object为不同对象， 锁定不同对象，则异步处理
	 */
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
	// ------------------------------------------------------------------------------------------------
	/**
	 * 多个线程访问同一个对象的2个不同方法，一个方法synchronized (object1) 另一个synchronized方法，锁定不同对象，则异步处理
	 */
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
    public synchronized void methodD() {
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
	// ------------------------------------------------------------------------------------------------
	/**
	 * 多个线程访问同一个对象的2个不同方法，一个方法synchronized (object1) 另一个方法普通方法，锁定用不同对象，则异步处理
	 */
//	private String lock1 = new String();
//	public void methodC() {
//		try {
//			System.out.println(Thread.currentThread().getName() + "方法开始");
//			synchronized (lock1) {
//				System.out.println(Thread.currentThread().getName() + " begin");
//				for (int i = 1; i <= 5; i++) {
//					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//					Thread.sleep(1000);
//				}
//				System.out.println(Thread.currentThread().getName() + "   end");
//			}
//			System.out.println(Thread.currentThread().getName() + "方法结束");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	public void methodD() {
//		try {
//			System.out.println(Thread.currentThread().getName() + "方法开始");
//			System.out.println(Thread.currentThread().getName() + "   begin");
//			for (int i = 1; i <= 5; i++) {
//				System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
//				Thread.sleep(1000);
//			}
//			System.out.println(Thread.currentThread().getName() + "     end");
//			System.out.println(Thread.currentThread().getName() + "方法结束");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	// ------------------------------------------------------------------------------------------------
	/**
	 * 多个线程访问不同对象的同一个synchronized (object1)修饰的方法，object1为同一个对象， 锁定不同对象，则异步处理
	 */

//    public void setUserNamePassWord(String userName, String passWord) {
//        try {
//            System.out.println(Thread.currentThread().getName() + "方法开始");
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
	// ------------------------------------------------------------------------------------------------
	/**
	 * 多个线程访问不同对象的同一个synchronized (object1)修饰的方法，object1为同一个对象， 锁定不同对象，则异步处理
	 */
	public void setUserNamePassWord(String userName, String passWord) {
		try {
			System.out.println(Thread.currentThread().getName() + "方法开始");
			String lock = new String();
			synchronized (lock) {
				System.out.println(
						"thread name=" + Thread.currentThread().getName() + " 进入代码快:" + System.currentTimeMillis());
				uname = userName;
				for (int i = 1; i <= 5; i++) {
					System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
					Thread.sleep(1000);
				}
				pwd = passWord;
				System.out.println("thread name=" + Thread.currentThread().getName() + " 进入代码快:"
						+ System.currentTimeMillis() + "入参uname:" + uname + "入参pwd:" + pwd);
			}
			System.out.println(Thread.currentThread().getName() + "方法结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}