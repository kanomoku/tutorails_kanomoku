package designPattern.patterns12_ProxyPattern.jdkProxy;

import designPattern.patterns12_ProxyPattern.jdkProxy.ISubject.IFunction;
import designPattern.patterns12_ProxyPattern.jdkProxy.Proxy.Secretary;
import designPattern.patterns12_ProxyPattern.jdkProxy.RealSubject.Boss;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        System.out.println(IFunction.class.getClassLoader() == Boss.class.getClassLoader());

        Boss boss = new Boss("云云");
        Secretary secretary = new Secretary(boss);

        // 第一个参数：反射时使用的类加载器
        // 第二个参数：Proxy需要实现什么接口
        // 第三个参数：通过接口对象调用方法时，需要调用哪个类的invoke
        IFunction function = (IFunction) Proxy.newProxyInstance(IFunction.class.getClassLoader(), new Class[]{IFunction.class}, secretary);

        function.eat("米饭");
        function.target();
    }
}
