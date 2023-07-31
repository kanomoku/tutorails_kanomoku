package designPattern.designPatterns11_FlyweightDesignPattern;

import java.util.HashMap;

public class A4_ShapeFactory {

	private static final HashMap<ShapeType,A1_Shape> shapes = new HashMap<ShapeType,A1_Shape>();

	public static A1_Shape getShape(ShapeType type) {
		A1_Shape shapeImpl = shapes.get(type);

		if (shapeImpl == null) {
			if (type.equals(ShapeType.OVAL_FILL)) {
				shapeImpl = new A3_Oval(true);
			} else if (type.equals(ShapeType.OVAL_NOFILL)) {
				shapeImpl = new A3_Oval(false);
			} else if (type.equals(ShapeType.LINE)) {
				shapeImpl = new A2_Line();
			}
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}
	
	public static enum ShapeType{
		OVAL_FILL,OVAL_NOFILL,LINE;
	}
}

