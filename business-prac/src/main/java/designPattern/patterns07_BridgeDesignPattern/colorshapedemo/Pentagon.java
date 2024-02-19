package designPattern.patterns07_BridgeDesignPattern.colorshapedemo;

import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.bridge.Shape;
import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.color.IColor;

public class Pentagon extends Shape {

	public Pentagon(IColor c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.println("Pentagon filled with color!! ");
		color.applyColor();
	} 
}

