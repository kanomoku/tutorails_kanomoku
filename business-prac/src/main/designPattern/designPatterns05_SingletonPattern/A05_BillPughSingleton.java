package designPattern.designPatterns05_SingletonPattern;

//This is the most widely used approach for Singleton class as it doesn’t require synchronization.
public class A05_BillPughSingleton {

	private A05_BillPughSingleton() {
	}

	//When the singleton class is loaded, 
	//SingletonHelper class is not loaded into memory and only when someone calls the getInstance method, 
	//this class gets loaded and creates the Singleton class instance.
	private static class SingletonHelper {
		private static final A05_BillPughSingleton INSTANCE = new A05_BillPughSingleton();
	}

	public static A05_BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
