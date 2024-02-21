package designPattern.patterns12_ProxyPattern.cglibProxy.RealSubject;

public class Boss {
    private String name;

    public Boss() {
    }

    public Boss(String name) {
        this.name = name;
    }

    public void target() {
        System.out.println("制定一个小目标");
    }

    public void eat(String str) {
        System.out.println("老板吃" + str);
    }
}
