package designPattern.patterns11_FlyweightDesignPattern.FlyweightFactory;

import designPattern.patterns11_FlyweightDesignPattern.ConcreteFlyweight.Line;
import designPattern.patterns11_FlyweightDesignPattern.ConcreteFlyweight.Oval;
import designPattern.patterns11_FlyweightDesignPattern.IFlyweight.IShape;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<ShapeType, IShape> shapes = new HashMap<>();

    public static IShape getShape(ShapeType type) {
        IShape shapeImpl = shapes.get(type);

        if (shapeImpl == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shapeImpl = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shapeImpl = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shapeImpl = new Line();
            }
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public enum ShapeType {
        OVAL_FILL, OVAL_NOFILL, LINE;
    }
}

