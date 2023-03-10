package designPattern.designPatterns05_SingletonPattern;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

public class A10_ReflectionDistorySingletonTest {

	@Test
	public void test1() {
		System.out.println("---1------------------------------------");
		A01_EagerInitializedSingleton instanceOne = A01_EagerInitializedSingleton.getInstance();
		A01_EagerInitializedSingleton instanceTwo = null;
		try {
			Constructor[] constructors = A01_EagerInitializedSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A01_EagerInitializedSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println("---1------------------------------------");
	}

	@Test
	public void test2() {
		System.out.println("---2------------------------------------");
		A02_StaticBlockInitializationSingleton instanceOne = A02_StaticBlockInitializationSingleton.getInstance();
		A02_StaticBlockInitializationSingleton instanceTwo = null;
		try {
			Constructor[] constructors = A02_StaticBlockInitializationSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A02_StaticBlockInitializationSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println("----2-----------------------------------");
	}

	@Test
	public void test3() {
		System.out.println("----3-----------------------------------");
		A03_LazyInitializedSingleton instanceOne = A03_LazyInitializedSingleton.getInstance();
		A03_LazyInitializedSingleton instanceTwo = null;
		try {
			Constructor[] constructors = A03_LazyInitializedSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A03_LazyInitializedSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println("----3-----------------------------------");
	}

	@Test
	public void test4() {
		System.out.println("----4-----------------------------------");
		A04_LazyInitializedSingletonThreadSafe instanceOne = A04_LazyInitializedSingletonThreadSafe.getInstance();
		A04_LazyInitializedSingletonThreadSafe instanceTwo = null;
		try {
			Constructor[] constructors = A04_LazyInitializedSingletonThreadSafe.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A04_LazyInitializedSingletonThreadSafe) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println("----4-----------------------------------");
	}

	@Test
	public void test5() {
		System.out.println("------5---------------------------------");
		A05_BillPughSingleton instanceOne = A05_BillPughSingleton.getInstance();
		A05_BillPughSingleton instanceTwo = null;
		try {
			Constructor[] constructors = A05_BillPughSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A05_BillPughSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println("------5---------------------------------");
	}

	@Test
	public void test6() {
		System.out.println("------6---------------------------------");
		A06_EnumSingleton instanceOne = A06_EnumSingleton.INSTANCE;
		System.out.println(instanceOne.hashCode());

		A06_EnumSingleton instanceTwo = null;
		try {
			Constructor[] constructors = A06_EnumSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A06_EnumSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceTwo.hashCode());
		System.out.println("----6-----------------------------------");

	}
	@Test
	public void test7() {
		System.out.println("-----7----------------------------------");
		A07_SerializedSingleton instanceOne = A07_SerializedSingleton.getInstance();
		A07_SerializedSingleton instanceTwo = null;
		try {
			Constructor[] constructors = A07_SerializedSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A07_SerializedSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		System.out.println("-----7----------------------------------");

	}
	
	@Test
	public void test8() {
		System.out.println("-----8----------------------------------");
		A08_SerializedSingletonReadResolve instanceOne = A08_SerializedSingletonReadResolve.getInstance();
//		System.out.println(instanceOne.hashCode());
		
		A08_SerializedSingletonReadResolve instanceTwo = null;
		try {
			Constructor[] constructors = A08_SerializedSingletonReadResolve.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (A08_SerializedSingletonReadResolve) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceTwo.hashCode());
		System.out.println("-----8----------------------------------");

	}
}
