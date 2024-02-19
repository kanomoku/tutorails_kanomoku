package designPattern.patterns07_BridgeDesignPattern.colorshapedemo;

import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.bridge.Shape;
import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.color.RedIColor;
import designPattern.patterns07_BridgeDesignPattern.colorshapedemo.color.GreenIColor;

public class Main {

	public static void main(String[] args) {
		Shape tri = new Triangle(new RedIColor());
		tri.applyColor();
		
		Shape pent = new Pentagon(new GreenIColor());
		pent.applyColor();
	}
}

