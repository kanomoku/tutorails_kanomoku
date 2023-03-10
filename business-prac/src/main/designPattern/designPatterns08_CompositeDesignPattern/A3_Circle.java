package designPattern.designPatterns08_CompositeDesignPattern;

public class A3_Circle implements A1_Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color "+fillColor);
	}
}
