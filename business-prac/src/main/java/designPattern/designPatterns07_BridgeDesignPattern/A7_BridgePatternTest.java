package designPattern.designPatterns07_BridgeDesignPattern;

public class A7_BridgePatternTest {

	public static void main(String[] args) {
		A2_Shape tri = new A3_Triangle(new A5_RedColor());
		tri.applyColor();
		
		A2_Shape pent = new A4_Pentagon(new A6_GreenColor());
		pent.applyColor();
	}
}

