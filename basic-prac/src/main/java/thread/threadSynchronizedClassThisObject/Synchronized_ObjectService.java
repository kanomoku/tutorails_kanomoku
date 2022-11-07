package thread.threadSynchronizedClassThisObject;

import java.util.Date;

public class Synchronized_ObjectService {
	private Object lock = new String();

	private static void command() {
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(200);
				System.out.println(" thread name:" + Thread.currentThread().getName() + "-->i=" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void serviceMethod_This() {
		System.out.println("方法serviceMethod_This Start");
		synchronized (this) {
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + new Date());
			command();
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + new Date());
		}
		System.out.println("方法serviceMethod_This End");
	}

	public void serviceMethod_This2() {
		System.out.println("方法serviceMethod_This2  Start");
		synchronized (this) {
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + new Date());
			command();
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + new Date());
		}
		System.out.println("方法serviceMethod_This2 End");
	}

	public synchronized void serviceMethod_Sync() {
		System.out.println("方法serviceMethod_Sync Start");
		command();
		System.out.println("方法serviceMethod_Sync End");
	}

	public synchronized void serviceMethod_Sync2() {
		System.out.println("方法serviceMethod_Sync2 Start");
		command();
		System.out.println("方法serviceMethod_Sync2 End");
	}

	public void serviceMethod_Object() {
		System.out.println("方法serviceMethod_Object Start");
		synchronized (lock) {
			System.out.println(
					"线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
			command();
			System.out
					.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
		}
		System.out.println("方法serviceMethod_Object End");
	}

	public void serviceMethod_Object2() {
		System.out.println("方法serviceMethod_Object2 Start");
		synchronized (lock) {
			System.out.println(
					"线程名称:" + Thread.currentThread().getName() + "  begin times:" + System.currentTimeMillis());
			command();
			System.out
					.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + System.currentTimeMillis());
		}
		System.out.println("方法serviceMethod_Object2 End");
	}

	public void serviceMethod() {
		System.out.println("方法serviceMethod Start" + new Date());
		command();
		System.out.println("方法serviceMethod End" + new Date());
	}

	public void serviceMethod2() {
		System.out.println("方法serviceMethod2 Start" + new Date());
		command();
		System.out.println("方法serviceMethod2 End" + new Date());
	}

	public static void serviceMethod3() {
		System.out.println("方法serviceMethod Start" + new Date());
		command();
		System.out.println("方法serviceMethod End" + new Date());
	}
	
	public void serviceMethod_Class() {
		System.out.println("方法serviceMethod_Class Start");
		synchronized (Synchronized_ObjectService.class) {
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + new Date());
			command();
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + new Date());
		}
		System.out.println("方法serviceMethod_Class End");
	}

	public void serviceMethod_Class2() {
		System.out.println("方法serviceMethod_Class2 Start");
		synchronized (Synchronized_ObjectService.class) {
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  begin times:" + new Date());
			command();
			System.out.println("线程名称:" + Thread.currentThread().getName() + "  end times:" + new Date());
		}
		System.out.println("方法serviceMethod_Class2 End");
	}

	public static synchronized void serviceMethod_Sync_static() {
		System.out.println("方法serviceMethod_Sync_static Start");
		command();
		System.out.println("方法serviceMethod_Sync_static End");
	}

	public static synchronized void serviceMethod_Sync_static2() {
		System.out.println("serviceMethod_Sync_static2 Start");
		command();
		System.out.println("serviceMethod_Sync_static2 End");
	}

	public static void serviceMethod_Sync_In_static() {
		System.out.println("方法serviceMethod_Sync_In_static Start");
		synchronized (Synchronized_ObjectService.class) {
			command();
		}
		System.out.println("方法serviceMethod_Sync_In_static End");
	}
	public static void serviceMethod_Sync_In_static2() {
		System.out.println("方法serviceMethod_Sync_In_static2 Start");
		synchronized (Synchronized_ObjectService.class) {
			command();
		}
		System.out.println("方法serviceMethod_Sync_In_static2 End");
	}
}