package designPattern.designPatterns05_SingletonPattern;

public class A01_EagerInitializedSingleton {

	private static final A01_EagerInitializedSingleton instance = new A01_EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private A01_EagerInitializedSingleton() {
	}

	public static A01_EagerInitializedSingleton getInstance() {
		return instance;
	}
}
