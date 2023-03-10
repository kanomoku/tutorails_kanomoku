package designPattern.designPatterns05_SingletonPattern;

public class A11_EagerInitializedSingletonClone implements Cloneable {

	private static final A11_EagerInitializedSingletonClone instance = new A11_EagerInitializedSingletonClone();

	// private constructor to avoid client applications to use constructor
	private A11_EagerInitializedSingletonClone() {
	}

	public static A11_EagerInitializedSingletonClone getInstance() {
		return instance;
	}
	
	@Override
	public A11_EagerInitializedSingletonClone clone() throws CloneNotSupportedException{
		A11_EagerInitializedSingletonClone employees = (A11_EagerInitializedSingletonClone)super.clone();
//		return employees;
		return instance;
	}
}
