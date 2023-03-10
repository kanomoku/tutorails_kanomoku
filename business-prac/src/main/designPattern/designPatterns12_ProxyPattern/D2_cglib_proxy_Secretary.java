package designPattern.designPatterns12_ProxyPattern;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


public class D2_cglib_proxy_Secretary implements MethodInterceptor {

	@Override
	// (生成的子类对象 ,  代理的方法 , 参数 , 子类生成的代理方法)
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {

		System.out.println("代理对象增加的信息----------预约时间");

		// invoke()调用子类重写方法
		// Object invoke = arg1.invoke(arg0, arg2); //這裡有問題還沒搞懂
		// invokeSuper

		Object abcd = arg3.invokeSuper(arg0, arg2);

		System.out.println("代理对象增加的信息----------留档");
		return abcd;
	}
}
