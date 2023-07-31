package designPattern.designPatterns08_CompositeDesignPattern;

public class A5_TestCompositePattern {

	public static void main(String[] args) {
		A1_Shape tri = new A2_Triangle();
		A1_Shape tri1 = new A2_Triangle();
		A1_Shape cir = new A3_Circle();
		
		A4_Drawing drawing = new A4_Drawing();
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

