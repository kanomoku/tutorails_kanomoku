package designPattern.designPatterns12_ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class C3_jdk_proxy_Secretary implements InvocationHandler {

	private C1_jdk_proxy_Function c1_jdk_proxy_Function;

	public C3_jdk_proxy_Secretary(C1_jdk_proxy_Function boss) {
		this.c1_jdk_proxy_Function = boss;
	}
//	private C2_jdk_proxy_Boss boss = new C2_jdk_proxy_Boss("云云");
	@Override
	//(生成的代理对象,方法,参数)
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理对象增加的信息----------预约时间");
//		Object abcd = method.invoke(boss, args);
		Object abcd = method.invoke(c1_jdk_proxy_Function, args);
		System.out.println("代理对象增加的信息----------记录访客信息");
		return abcd;
	}
}
