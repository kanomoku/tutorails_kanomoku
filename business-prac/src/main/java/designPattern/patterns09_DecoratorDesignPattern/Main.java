package designPattern.patterns09_DecoratorDesignPattern;

import designPattern.patterns09_DecoratorDesignPattern.ComponentImplementation.BasicCar;
import designPattern.patterns09_DecoratorDesignPattern.ComponentInterface.ICar;
import designPattern.patterns09_DecoratorDesignPattern.ConcreteDecorators.LuxuryCar;
import designPattern.patterns09_DecoratorDesignPattern.ConcreteDecorators.SportsCar;

public class Main {

    public static void main(String[] args) {
        ICar sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("--------------------");

        ICar luxuryCar = new LuxuryCar(new BasicCar());
        luxuryCar.assemble();
        System.out.println("--------------------");

        ICar sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
