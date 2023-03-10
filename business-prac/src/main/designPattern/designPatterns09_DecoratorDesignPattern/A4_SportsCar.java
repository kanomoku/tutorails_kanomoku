package designPattern.designPatterns09_DecoratorDesignPattern;

public class A4_SportsCar extends A3_CarDecorator {

	public A4_SportsCar(A1_Car c) {
		super(c);
		System.out.println("A4_SportsCar 构造方法");
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.println("装饰1：Adding features of Sports Car.");
	}
}

