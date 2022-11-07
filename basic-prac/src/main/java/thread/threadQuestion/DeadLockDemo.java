package thread.threadQuestion;

import java.util.Date;

public class DeadLockDemo {
	private static Object resource1 = new Object();// 资源 1
	private static Object resource2 = new Object();// 资源 2

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (resource1) {
				System.out.println(Thread.currentThread().getName() + " get resource1 at " + new Date());
				command();
				System.out.println(Thread.currentThread().getName() + " waiting get resource2 at " + new Date());
				synchronized (resource2) {
					System.out.println(Thread.currentThread().getName() + " get resource2 at " + new Date());
				}
			}
		}, "线程 1").start();

		// 会死锁
//		new Thread(() -> {
//			synchronized (resource2) {
//				System.out.println(Thread.currentThread().getName() + " get resource2 at " + new Date());
//				command();
//				System.out.println(Thread.currentThread().getName() + " waiting get resource1 at " + new Date());
//				synchronized (resource1) {
//					System.out.println(Thread.currentThread().getName() + " get resource1 at " + new Date());
//				}
//			}
//		}, "线程 2").start();

		// 破坏了破坏循环等待条件，因此避免了死锁 没怎么懂
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get resource1 at "+ new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting get resource2 at "+ new Date());
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource2 at "+ new Date());
                }
            }
        }, "线程 2").start();
	}

	private static void command() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
