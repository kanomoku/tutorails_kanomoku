package designPattern.designPatterns05_SingletonPattern;

public class A02_StaticBlockInitializationSingleton {

	private static A02_StaticBlockInitializationSingleton instance;

	private A02_StaticBlockInitializationSingleton() {
	}

	// Static block initialization implementation is similar to eager initialization, 
	// except that instance of class is created in the static block that provides option for exception handling.
	static {
		try {
			instance = new A02_StaticBlockInitializationSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static A02_StaticBlockInitializationSingleton getInstance() {
		return instance;
	}
}