package designPattern.designPatterns07_BridgeDesignPattern;

public class A4_Pentagon extends A2_Shape{

	public A4_Pentagon(A1_Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.println("Pentagon filled with color!! ");
		color.applyColor();
	} 
}

