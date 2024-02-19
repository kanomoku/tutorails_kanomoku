package designPattern.patterns07_BridgeDesignPattern.colorshapedemo.bridge;

import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.color.IColor;

public abstract class Shape {
    protected IColor color;

    public Shape(IColor c) {
        this.color = c;
    }

    public abstract void applyColor();
}

