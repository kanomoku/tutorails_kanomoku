package designPattern.patterns12_ProxyPattern.cglibProxy.Proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class Secretary implements MethodInterceptor {

    @Override
    // (生成的子类对象 ,  代理的方法 , 参数 , 子类生成的代理方法)
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("代理对象增加的信息----------预约时间");

        Object abcd = methodProxy.invokeSuper(obj, args);

        System.out.println("代理对象增加的信息----------留档");
        return abcd;
    }
}
