package designPattern.designPatterns09_DecoratorDesignPattern;

public class A3_CarDecorator implements A1_Car {

	protected A1_Car car;
	
	public A3_CarDecorator(A1_Car c){
		this.car=c;
		System.out.println("A3_CarDecorator 构造方法");
	}
	
	@Override
	public void assemble() {
		System.out.println("Decorator 被调用前 记录一下.");
		this.car.assemble();
		System.out.println("Decorator 被调用后 记录一下.");
	}
}

