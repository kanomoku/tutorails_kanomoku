package designPattern.designPatterns05_SingletonPattern;

public class A03_LazyInitializedSingleton {

	private static A03_LazyInitializedSingleton instance;

	private A03_LazyInitializedSingleton() {
	}

	public static A03_LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new A03_LazyInitializedSingleton();
		}
		return instance;
	}
}