package designPattern.patterns08_CompositeDesignPattern;

import designPattern.patterns08_CompositeDesignPattern.basecomponent.Shape;
import designPattern.patterns08_CompositeDesignPattern.composite.Drawing;
import designPattern.patterns08_CompositeDesignPattern.leaf.Triangle;
import designPattern.patterns08_CompositeDesignPattern.leaf.Circle;

public class Main {

	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();
		
		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		
		drawing.draw("Red");
		
		drawing.clear();
		
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}

}

