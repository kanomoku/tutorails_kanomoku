package designPattern.pattern05_SingletonPattern.billpugh;

//This is the most widely used approach for Singleton class as it doesn’t require synchronization.
public class BillPughSingleton {

	private BillPughSingleton() {
	}

	//When the singleton class is loaded, 
	//SingletonHelper class is not loaded into memory and only when someone calls the getInstance method, 
	//this class gets loaded and creates the Singleton class instance.
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
