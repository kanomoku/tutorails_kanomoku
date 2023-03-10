package designPattern.designPatterns07_BridgeDesignPattern;

public class A3_Triangle extends A2_Shape{

	public A3_Triangle(A1_Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.println("Triangle filled with color!! ");
		color.applyColor();
	} 
}
