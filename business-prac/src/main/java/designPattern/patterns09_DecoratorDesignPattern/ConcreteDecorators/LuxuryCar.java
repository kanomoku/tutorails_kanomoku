package designPattern.patterns09_DecoratorDesignPattern.ConcreteDecorators;


import designPattern.patterns09_DecoratorDesignPattern.ComponentInterface.ICar;
import designPattern.patterns09_DecoratorDesignPattern.Decorator.CarDecorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(ICar c) {
		super(c);
		System.out.println("LuxuryCar 构造方法");
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.println("Adding features of Luxury Car.");
	}
}

