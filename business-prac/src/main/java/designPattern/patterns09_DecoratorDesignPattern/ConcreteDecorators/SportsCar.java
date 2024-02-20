package designPattern.patterns09_DecoratorDesignPattern.ConcreteDecorators;

import designPattern.patterns09_DecoratorDesignPattern.ComponentInterface.ICar;
import designPattern.patterns09_DecoratorDesignPattern.Decorator.CarDecorator;

public class SportsCar extends CarDecorator {

    public SportsCar(ICar c) {
        super(c);
        System.out.println("SportsCar 构造方法");
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Sports Car.");
    }
}

