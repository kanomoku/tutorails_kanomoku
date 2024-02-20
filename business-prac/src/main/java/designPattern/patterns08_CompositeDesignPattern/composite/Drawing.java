package designPattern.patterns08_CompositeDesignPattern.composite;

import designPattern.patterns08_CompositeDesignPattern.basecomponent.Shape;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

    //collection of Shapes
    private final List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        for (Shape shape : shapes) {
            shape.draw(fillColor);
        }
    }

    //adding shape to drawing
    public void add(Shape s) {
        this.shapes.add(s);
    }

    //removing shape from drawing
    public void remove(Shape s) {
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear() {
        shapes.clear();
    }
}

