package designPattern.patterns09_DecoratorDesignPattern.ComponentImplementation;

import designPattern.patterns09_DecoratorDesignPattern.ComponentInterface.ICar;

public class BasicCar implements ICar {
    public BasicCar() {
        System.out.println("BasicCar 构造方法");
    }

    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }
}

