package designPattern.patterns09_DecoratorDesignPattern.Decorator;

import designPattern.patterns09_DecoratorDesignPattern.ComponentInterface.ICar;

public class CarDecorator implements ICar {

    protected ICar car;

    public CarDecorator(ICar c) {
        this.car = c;
        System.out.println("CarDecorator 构造方法");
    }

    @Override
    public void assemble() {
        System.out.println("Decorator 被调用前 记录一下.");
        this.car.assemble();
        System.out.println("Decorator 被调用后 记录一下.");
    }
}

