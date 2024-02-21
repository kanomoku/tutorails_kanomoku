package designPattern.patterns12_ProxyPattern.cglibProxy;

import designPattern.patterns12_ProxyPattern.cglibProxy.Proxy.Secretary;
import designPattern.patterns12_ProxyPattern.cglibProxy.RealSubject.Boss;
import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Boss.class);
        enhancer.setCallback(new Secretary());
        Boss boss = (Boss) enhancer.create();
        boss.eat("土豆");
    }
}
