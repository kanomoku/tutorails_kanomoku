package designPattern.designPatterns05_SingletonPattern;

public class A062_BillPughSingleton {

	private A062_BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final A062_BillPughSingleton INSTANCE = new A062_BillPughSingleton();
	}

	public static A062_BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
