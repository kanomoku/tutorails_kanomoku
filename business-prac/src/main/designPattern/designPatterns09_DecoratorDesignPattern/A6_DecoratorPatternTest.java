package designPattern.designPatterns09_DecoratorDesignPattern;

public class A6_DecoratorPatternTest {

	public static void main(String[] args) {
		A1_Car sportsCar = new A4_SportsCar(new A2_BasicCar());
		sportsCar.assemble();
		System.out.println("*****");
		A1_Car luxuryCar = new A5_LuxuryCar(new A2_BasicCar());
		luxuryCar.assemble();
		System.out.println("*****");
		A1_Car sportsLuxuryCar = new A4_SportsCar(new A5_LuxuryCar(new A2_BasicCar()));
		sportsLuxuryCar.assemble();
	}

}
