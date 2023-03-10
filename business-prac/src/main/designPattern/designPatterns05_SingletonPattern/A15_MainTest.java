package designPattern.designPatterns05_SingletonPattern;

public class A15_MainTest {

	public A15_MainTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		System.out.println(A14_ThreadLocalSingleton.getInstance());
		System.out.println(A14_ThreadLocalSingleton.getInstance());
		System.out.println(A14_ThreadLocalSingleton.getInstance());
		System.out.println(A14_ThreadLocalSingleton.getInstance());

	}
}
