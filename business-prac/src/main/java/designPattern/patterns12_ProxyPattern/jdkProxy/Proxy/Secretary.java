package designPattern.patterns12_ProxyPattern.jdkProxy.Proxy;

import designPattern.patterns12_ProxyPattern.jdkProxy.ISubject.IFunction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Secretary implements InvocationHandler {

    private IFunction function;

    public Secretary(IFunction boss) {
        this.function = boss;
    }

    @Override
    //(生成的代理对象,方法,参数)
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象增加的信息----------预约时间");
        Object abcd = method.invoke(function, args);
        System.out.println("代理对象增加的信息----------记录访客信息");
        return abcd;
    }
}
