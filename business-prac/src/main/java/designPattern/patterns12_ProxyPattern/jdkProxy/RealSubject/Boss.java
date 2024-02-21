package designPattern.patterns12_ProxyPattern.jdkProxy.RealSubject;

import designPattern.patterns12_ProxyPattern.jdkProxy.ISubject.IFunction;

public class Boss implements IFunction {
    private String name;

    public Boss() {
    }

    public Boss(String name) {
        this.name = name;
    }

    public void target() {
        System.out.println(name + "制定一个小目标");
    }

    @Override
    public void eat(String str) {
        System.out.println(name + "老板吃" + str);
    }
}
