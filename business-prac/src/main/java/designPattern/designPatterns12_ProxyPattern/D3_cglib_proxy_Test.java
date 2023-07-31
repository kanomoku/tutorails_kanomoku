package designPattern.designPatterns12_ProxyPattern;

import org.springframework.cglib.proxy.Enhancer;

public class D3_cglib_proxy_Test {
	public static void main(String[] args) {
//		十二: cglib 动态代理
//		1. cglib 优点:
//			1.1 基于字节码,生成真实对象的子类.
//				1.1.1 运行效率高于JDK 动态代理.
//			1.2 不需要实现接口
//		2. cglib 缺点:
//			2.1 非JDK 功能,需要额外导入jar
//		3. 使用spring aop 时,只要出现Proxy 和真实对象转换异常
//			3.1 设置为true 使用cglib
//			3.2 设置为false 使用jdk(默认值)
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(D1_cglib_proxy_Boss.class);
		enhancer.setCallback(new D2_cglib_proxy_Secretary());
		D1_cglib_proxy_Boss boss = (D1_cglib_proxy_Boss) enhancer.create();
		boss.eat("土豆");
	}
}
