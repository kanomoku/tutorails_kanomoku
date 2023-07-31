package designPattern.designPatterns08_CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class A4_Drawing implements A1_Shape{

	//collection of Shapes
	private List<A1_Shape> shapes = new ArrayList<A1_Shape>();
	
	@Override
	public void draw(String fillColor) {
		for(A1_Shape sh : shapes)
		{
			sh.draw(fillColor);
		}
	}
	
	//adding shape to drawing
	public void add(A1_Shape s){
		this.shapes.add(s);
	}
	
	//removing shape from drawing
	public void remove(A1_Shape s){
		shapes.remove(s);
	}
	
	//removing all the shapes
	public void clear(){
		System.out.println("Clearing all the shapes from drawing");
		this.shapes.clear();
	}
}

