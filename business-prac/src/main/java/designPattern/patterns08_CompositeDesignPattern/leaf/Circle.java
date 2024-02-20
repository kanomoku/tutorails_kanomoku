package designPattern.patterns08_CompositeDesignPattern.leaf;

import designPattern.patterns08_CompositeDesignPattern.basecomponent.Shape;

public class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color "+fillColor);
	}
}
