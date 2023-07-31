package designPattern.designPatterns12_ProxyPattern;

import java.lang.reflect.Proxy;

public class C4_jdk_proxy_Test {
	public static void main(String[] args) {
//		十一. JDK 动态代理
//		1. 和cglib 动态代理对比
//			1.1 优点:jdk 自带,不需要额外导入jar
//		1.2 缺点:
//			1.2.1 真实对象必须实现接口
//			1.2.2 利用反射机制.效率不高.
//		2. 使用JDK 动态代理时可能出现下面异常
//			2.1 出现原因:希望把接口对象转换为具体真实对象
//		

		System.out.println(C1_jdk_proxy_Function.class.getClassLoader() == C2_jdk_proxy_Boss.class.getClassLoader());

//		C3_jdk_proxy_Secretary secretary = new C3_jdk_proxy_Secretary();

		C2_jdk_proxy_Boss boss = new C2_jdk_proxy_Boss("云云");
		C3_jdk_proxy_Secretary secretary = new C3_jdk_proxy_Secretary(boss);

		// 第一个参数：反射时使用的类加载器
		// 第二个参数：Proxy需要实现什么接口
		// 第三个参数：通过接口对象调用方法时，需要调用哪个类的invoke
		C1_jdk_proxy_Function function = (C1_jdk_proxy_Function) Proxy.newProxyInstance(
				C1_jdk_proxy_Function.class.getClassLoader(), new Class[] { C1_jdk_proxy_Function.class }, secretary);

		function.eat("米饭");
		function.target();
	}
}
