package designPattern.designPatterns08_CompositeDesignPattern;

public class A2_Triangle implements A1_Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color "+fillColor);
	}
}

