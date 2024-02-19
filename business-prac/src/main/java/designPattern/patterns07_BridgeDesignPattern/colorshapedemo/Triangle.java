package designPattern.patterns07_BridgeDesignPattern.colorshapedemo;

import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.bridge.Shape;
import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.color.IColor;

public class Triangle extends Shape {

    public Triangle(IColor c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.println("Triangle filled with color!! ");
        color.applyColor();
    }
}
