package thread.threadSynchronizedClassThisObject;

public class Synchronized_MainTest {

	public static void main(String[] args) {

		// 无锁
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_Thread a = new Synchronized_Thread(service);
//		a.start();
//		Synchronized_Thread2 b = new Synchronized_Thread2(service);
//		b.start();

		// 对象锁
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_Thread_This a = new Synchronized_Thread_This(service);
//		a.start();
//		Synchronized_Thread_This2 b = new Synchronized_Thread_This2(service);
//		b.start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_Thread_Sync a = new Synchronized_Thread_Sync(service);
//		a.start();
//		Synchronized_Thread_Sync2 b = new Synchronized_Thread_Sync2(service);
//		b.start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_This(service).start();
//		new Synchronized_Thread_Sync(service).start();

		// ------------------------------------------------------------------------------------
		// 私有锁
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_Thread_Object a = new Synchronized_Thread_Object(service);
//		a.start();
//		Synchronized_Thread_Object2 b = new Synchronized_Thread_Object2(service);
//		b.start();

		// 类锁
		//多线程访问  对象监视器为同一任务对象
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_Class(service).start();
//		new Synchronized_Thread_Class2(service).start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_Class(service).start();
//		new Synchronized_Thread_Sync_Static(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_Class(service).start();
//		new Synchronized_Thread_Sync_In_Static(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_Sync_Static(service).start();
//		new Synchronized_Thread_Sync_Static2(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_Sync_Static(service).start();
//		new Synchronized_Thread_Sync_In_Static(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_Sync_In_Static(service).start();
//		new Synchronized_Thread_Sync_In_Static2(service).start();		
		
		//多线程访问  对象监视器为同一个类的不同任务对象
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_ObjectService service2 = new Synchronized_ObjectService();
//		new Synchronized_Thread_Class(service).start();
//		new Synchronized_Thread_Class2(service2).start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_ObjectService service2 = new Synchronized_ObjectService();
//		new Synchronized_Thread_Class(service).start();
//		new Synchronized_Thread_Sync_Static(service2).start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_ObjectService service2 = new Synchronized_ObjectService();
//		new Synchronized_Thread_Class(service).start();
//		new Synchronized_Thread_Sync_In_Static(service2).start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_ObjectService service2 = new Synchronized_ObjectService();
//		new Synchronized_Thread_Sync_Static(service).start();
//		new Synchronized_Thread_Sync_Static2(service2).start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_ObjectService service2 = new Synchronized_ObjectService();
//		new Synchronized_Thread_Sync_Static(service).start();
//		new Synchronized_Thread_Sync_In_Static(service2).start();

//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		Synchronized_ObjectService service2 = new Synchronized_ObjectService();
//		new Synchronized_Thread_Sync_In_Static(service).start();
//		new Synchronized_Thread_Sync_In_Static2(service2).start();			

		//多线程访问  任务对象的类 任务对象 		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_JustClass_Sync_Static().start();		
//		new Synchronized_Thread_Class(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_JustClass_Sync_Static().start();		
//		new Synchronized_Thread_Sync_Static(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_JustClass_Sync_Static().start();		
//		new Synchronized_Thread_Sync_In_Static(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_JustClass_Sync_In_Static().start();		
//		new Synchronized_Thread_Class(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_JustClass_Sync_In_Static().start();		
//		new Synchronized_Thread_Sync_Static(service).start();
		
//		Synchronized_ObjectService service = new Synchronized_ObjectService();
//		new Synchronized_Thread_JustClass_Sync_In_Static().start();		
//		new Synchronized_Thread_Sync_In_Static(service).start();		
		
		
	}
}