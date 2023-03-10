package designPattern.designPatterns05_SingletonPattern;

public class A14_ThreadLocalSingleton {

	private A14_ThreadLocalSingleton() {
	}

	private static final ThreadLocal<A14_ThreadLocalSingleton> threadLocalOInstance = 
			new ThreadLocal<A14_ThreadLocalSingleton>() {
				protected A14_ThreadLocalSingleton initialValue() {
					return new A14_ThreadLocalSingleton();
				}
			};

	public static A14_ThreadLocalSingleton getInstance() {
		return threadLocalOInstance.get();
	}
}
