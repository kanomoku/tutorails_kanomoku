package designPattern.designPatterns09_DecoratorDesignPattern;


public class A5_LuxuryCar extends A3_CarDecorator {

	public A5_LuxuryCar(A1_Car c) {
		super(c);
		System.out.println("A5_LuxuryCar 构造方法");
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.println("装饰2： Adding features of Luxury Car.");
	}
}

