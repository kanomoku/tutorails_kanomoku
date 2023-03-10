package designPattern.designPatterns09_DecoratorDesignPattern;

public class A2_BasicCar implements A1_Car {

	
	public A2_BasicCar() {
		System.out.println("A2_BasicCar 构造方法");
	}

	@Override
	public void assemble() {
		System.out.println("Basic Car.");
	}
}

